import java.util.HashSet;
import java.util.Set;

public class CountLatticePointsInsideaCircle {
    public int countLatticePoints(int[][] circles) {
        //https://leetcode.com/problems/count-lattice-points-inside-a-circle/ 2249
        Set<String> s = new HashSet<>();

        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int z = circle[2];

            for (int i = x - z; i <= x + z; i++) {
                for (int j = y - z; j <= y + z; j++) {
                    if ((i - x) * (i - x) + (j - y) * (j - y) <= z * z) {
                        s.add(i + " , " + j);
                    }
                }
            }
        }

        return s.size();
    }
}
