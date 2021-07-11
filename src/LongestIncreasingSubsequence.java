import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    //https://leetcode.com/problems/longest-increasing-subsequence/ 300
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int num: nums){
            Integer highest = ts.ceiling(num);
            if(highest == null){
                ts.add(num);
            }else{
                ts.remove(highest);
                ts.add(num);
            }
        }

        return ts.size();
    }
}
