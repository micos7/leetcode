import java.util.*;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //https://leetcode.com/problems/all-paths-from-source-to-target/ 797
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        int finalNode = graph.length - 1;
        while (!q.isEmpty()) {
            List<Integer> node = q.poll();
            int lastNode = node.get(node.size() - 1);
            if (lastNode == finalNode) {
                ans.add(new ArrayList<>(node));
            } else {
                int[] possibilities = graph[lastNode];
                for (int posiblity : possibilities) {
                    List<Integer> temp = new ArrayList<>(node);
                    temp.add(posiblity);
                    q.add(temp);
                }
            }

        }
        return ans;
    }

    //dfs approach
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        helper(graph,0,t,ans);
        return ans;
    }

    private void helper(int[][] graph,int position,List<Integer> temp,List<List<Integer>> ans){
        if(position == graph.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int neighbour:graph[position]){
            temp.add(neighbour);
            helper(graph,neighbour,temp,ans);
            temp.remove(temp.size()-1);
        }

    }
}
