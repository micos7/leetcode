import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //https://leetcode.com/problems/merge-intervals/ 56
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals,(arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] cur_interval = intervals[0];
        ans.add(cur_interval);

        for(int[] interval: intervals){
            int cur_end = cur_interval[1];
            int next_first = interval[0];
            int next_last = interval[1];

            if(cur_end >= next_first){
                cur_interval[1] = Math.max(cur_end,next_last);
            }else{
                cur_interval = interval;
                ans.add(cur_interval);
            }
        }


        return ans.toArray(new int[ans.size()][]);
    }
}
