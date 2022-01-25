import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //https://leetcode.com/problems/subsets/ 78
        List<List<Integer>> ans = new ArrayList<>();
        traverse(0,ans,new ArrayList<Integer>(),nums);
        return ans;
    }

    private void traverse(int index,List<List<Integer>> ans,List<Integer> temp,int[] nums){
        ans.add(new ArrayList<>(temp));
        for(int i =index;i<nums.length;i++){
            temp.add(nums[i]);
            traverse(i+1,ans,temp,nums);
            temp.remove(temp.size() -1);
        }
    }
}
