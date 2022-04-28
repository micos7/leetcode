import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        //https://leetcode.com/problems/heaters/ 475
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            if (idx < 0) idx = -(idx + 1);

            int d1 = idx - 1 >= 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            int d2 = idx < heaters.length ? heaters[idx] - house : Integer.MAX_VALUE;

            ans = Math.max(ans, Math.min(d1, d2));
        }

        return ans;
    }
}
