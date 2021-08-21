import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //https://leetcode.com/problems/insert-interval/ 57
        LinkedList<int[]> ans = new LinkedList<>();

        for(int[] in: intervals){
            if(in[1] < newInterval[0]){
                ans.add(in);
            }else if(newInterval[1] < in[0]){
                ans.add(newInterval);
                newInterval = in;
            }else{
                newInterval[0] = Math.min(newInterval[0],in[0]);
                newInterval[1] = Math.max(newInterval[1],in[1]);
            }
        }

        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);
    }
}
