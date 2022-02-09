import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //https://leetcode.com/problems/increasing-subsequences/ 491
        List<List<Integer>> ans = new ArrayList<>();
        rec(nums,0,ans, new ArrayList<Integer>());
        return ans;
    }

    private void rec(int[] nums,int index,List<List<Integer>> ans,List<Integer> temp){

        if(temp.size() >1){
            ans.add(new ArrayList<>(temp));
        }

        Set<Integer> set = new HashSet<>();
        for(int i =index;i<nums.length;i++){
            if(!set.add(nums[i])) continue;

            if(temp.isEmpty() || nums[i] >= temp.get(temp.size()-1)){
                temp.add(nums[i]);
                rec(nums,i+1,ans,temp);
                temp.remove(temp.size()-1);
            }

        }
    }
}
