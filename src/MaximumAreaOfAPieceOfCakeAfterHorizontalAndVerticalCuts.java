import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    //    https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/submissions/ 1465
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            int width = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = Math.max(maxHeight, width);
        }

        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            int height = verticalCuts[i] - verticalCuts[i - 1];
            maxWidth = Math.max(maxWidth, height);
        }

        long answer = maxHeight * maxWidth;

        return (int) (answer % 1000000007);
    }
}
