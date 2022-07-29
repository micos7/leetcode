import java.util.HashMap;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        //https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/ 1477
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        hm.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            hm.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.get(sum - target) != null) {
                lsize = Math.min(lsize, i - hm.get(sum - target));
            }
            if (hm.get(sum + target) != null && lsize < Integer.MAX_VALUE) {
                result = Math.min(result, hm.get(sum + target) - i + lsize);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
