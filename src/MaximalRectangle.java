import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        //https://leetcode.com/problems/maximal-rectangle/ 85
        if (matrix.length == 0) return 0;
        int area = 0;
        int[] h = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0;
                } else {
                    h[j] += 1;
                }
            }
            area = Math.max(area, findArea(h));
        }

        return area;
    }

    private int findArea(int[] h) {
        int area = 0;
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 1; i < h.length; i++) {
            int cur = h[i];
            if (s.isEmpty() || cur >= h[s.peek()]) {
                s.add(i);
            } else {
                while (!s.isEmpty() && cur < h[s.peek()]) {
                    int temp = h[s.pop()];
                    if (s.isEmpty()) {
                        area = Math.max(area, temp * i);
                    } else {
                        area = Math.max(area, temp * (i - s.peek() - 1));
                    }
                }
                s.add(i);
            }
        }


        if (!s.isEmpty()) {
            while (!s.isEmpty()) {
                int i = h.length;
                int temp = h[s.pop()];
                if (s.isEmpty()) {
                    area = Math.max(area, temp * i);
                } else {
                    area = Math.max(area, temp * (i - s.peek() - 1));

                }
            }
        }
        return area;
    }
}
