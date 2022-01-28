import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //https://leetcode.com/problems/permutations-ii/ 47
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] seen = new boolean[nums.length];
        generate(ans,1,new ArrayList<Integer>(),nums,seen);
        return ans;
    }

    private void generate(List<List<Integer>> ans, int index, List<Integer> temp, int[] nums, boolean[] seen){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(seen[i]) continue;
            if(i > 0 && nums[i-1] == nums[i] && !seen[i-1]) continue;
            seen[i] = true;
            temp.add(nums[i]);
            generate(ans,index+1, temp,nums,seen);
            temp.remove(temp.size()-1);
            seen[i] = false;

        }
    }
}
