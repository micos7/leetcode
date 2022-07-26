import java.util.*;

public class FindAllPossibleRecipesfromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/ 2115
        Map<String, List<String>> adjList = new HashMap<>();
        Set<String> visit = new HashSet<>();

        for (int i = 0; i < recipes.length; i++) {
            List<String> preReq = new ArrayList<>();
            for (String ing : ingredients.get(i)) {
                if (!Arrays.asList(supplies).contains(ing)) preReq.add(ing);
            }
            adjList.put(recipes[i], preReq);
        }

        List<String> res = new ArrayList<>();
        for (String recipe : recipes) {
            if (dfs(recipe, visit, adjList)) res.add(recipe);
        }
        return res;
    }

    private boolean dfs(String recipe, Set<String> visit, Map<String, List<String>> adjList) {
        if (adjList.get(recipe) == null) return false;
        if (adjList.get(recipe).size() == 0) return true;
        if (visit.contains(recipe)) return false;

        visit.add(recipe);
        for (String preRe : adjList.get(recipe)) {
            if (!dfs(preRe, visit, adjList)) return false;
        }
        adjList.put(recipe, new ArrayList<>());
        return true;
    }

}
