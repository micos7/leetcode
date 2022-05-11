import java.util.Stack;

public class NumberofVisiblePeopleinaQueue {
    public int[] canSeePersonsCount(int[] heights) {
        //https://leetcode.com/problems/number-of-visible-people-in-a-queue/ 1944
        int[] ans = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                int[] pop = stack.pop();
                ans[pop[0]]++;
            }
            if (!stack.isEmpty()) {
                ans[stack.peek()[0]]++;
            }
            stack.push(new int[]{i, heights[i]});
        }
        return ans;
    }
}
