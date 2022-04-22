import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        //https://leetcode.com/problems/largest-rectangle-in-histogram/ 84
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int area = 0;

        Stack<Integer> s = new Stack<>();
        s.add(0);

        for (int i = 1; i < heights.length; i++) {
            int cur = heights[i];
            if (cur >= heights[s.peek()]) {
                s.add(i);
            } else {
                while (!s.isEmpty() && cur < heights[s.peek()]) {
                    int temp = heights[s.pop()];
                    if (s.isEmpty()) {
                        area = Math.max(area, temp * i);
                    } else {
                        area = Math.max(area, temp * (i - s.peek() - 1));
                    }
                }
                s.add(i);
            }
        }

        int i = heights.length;
        while (!s.isEmpty()) {
            int temp = heights[s.pop()];
            if (s.isEmpty()) {
                area = Math.max(area, temp * i);
            } else {
                area = Math.max(area, temp * (i - s.peek() - 1));
            }
        }
        return area;
    }
}
