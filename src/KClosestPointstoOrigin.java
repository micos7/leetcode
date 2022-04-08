import java.util.Arrays;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        //https://leetcode.com/problems/k-closest-points-to-origin/ 973
        Arrays.sort(points,(a, b)-> (a[0]*a[0] + a[1]*a[1]) -(b[0]*b[0] + b[1]*b[1]));
        return Arrays.copyOf(points,k);
    }
}
