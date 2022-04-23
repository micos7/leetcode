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

    //another version

    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        if(heights.length==1)
            return heights[0];
        int area=0;
        int curArea = 0;


        Stack<Integer> istack= new Stack<>();
        Stack<Integer> hstack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            int lastWidth = Integer.MAX_VALUE;
            while( !hstack.isEmpty() && hstack.peek() > heights[i]){
                lastWidth = istack.peek();
                curArea = (i - istack.pop()) * hstack.pop();
                area = Math.max(area,curArea);
            }
            if(hstack.empty() || hstack.peek() < heights[i]){
                hstack.add(heights[i]);
                istack.add(Math.min(lastWidth,i));
            }
        }

        while(!hstack.isEmpty()){
            curArea = (heights.length - istack.pop()) * hstack.pop();
            area = Math.max(area,curArea);
        }



        return area;
    }
}
