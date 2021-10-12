import java.util.Arrays;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //https://leetcode.com/problems/non-overlapping-intervals/ 435
        Arrays.sort(intervals,(a, b) -> (a[0] - b[0]));
        int count = 0, last_included = 0;
        for(int i =1;i < intervals.length;i++){
            if(intervals[i][0] < intervals[last_included][1]){
                count++;
                if(intervals[i][1] < intervals[last_included][1]) last_included = i;
            }else{
                last_included = i;
            }
        }

        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[1] - b[1]));

        int count = 0, prev = intervals[0][1];
        for(int i =1;i < intervals.length;i++){
            if(intervals[i][0] < prev){
                count++;
            }else{
                prev = intervals[i][1];
            }
        }

        return count;
    }
}
}
