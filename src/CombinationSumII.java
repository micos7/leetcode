import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    //https://leetcode.com/problems/combination-sum-ii/ 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        traverse(ans,candidates,target,0, new ArrayList<Integer>());
        return ans;
    }

    private void  traverse(List<List<Integer>> ans,int[] candidates, int target,int index, List<Integer> temp){

        if(target == 0){
            ans.add(new ArrayList<>(temp));
        }
        if(target < 0){
            return;
        }
        for(int i = index;i<candidates.length;i++){
            if(i == index || candidates[i] != candidates[i-1]){
                temp.add(candidates[i]);
                traverse(ans,candidates,target- candidates[i],i+1, temp);
                temp.remove(temp.size()-1);

            }

        }
    }
}
