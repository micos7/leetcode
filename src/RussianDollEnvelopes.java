import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        //https://leetcode.com/problems/russian-doll-envelopes/ 354
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        int[] heights = new int[envelopes.length];

        int maxHeight = 0;

        for (int[] env : envelopes) {

            int cur = env[1];
            int index = Arrays.binarySearch(heights, 0, maxHeight, cur);
            if (index < 0) {
                index = -index - 1;
            }
            if (maxHeight == index)
                maxHeight += 1;
            heights[index] = cur;
        }

        return maxHeight;
    }
}
