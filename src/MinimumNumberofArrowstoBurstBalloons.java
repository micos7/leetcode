import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/ 452
        Arrays.sort(points,(a, b) -> (Integer.compare(a[1],b[1])));
        int arrows =1;
        int reach = points[0][1];
        for(int i = 1;i<points.length;i++){
            if(points[i][0] > reach){
                arrows+=1;
                reach = points[i][1];
            }
        }
        return arrows;
    }
}
