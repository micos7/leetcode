import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //https://leetcode.com/problems/contains-duplicate-ii/ 219
        HashMap<Integer, Integer> hm = new HashMap();

        for (int j = 0; j < nums.length; j++) {
            if (hm.get(nums[j]) != null && Math.abs(j - hm.get(nums[j])) <= k && nums[j] == nums[hm.get(nums[j])]) {
                return true;
            }
            hm.put(nums[j], j);

        }
        return false;
    }
}
