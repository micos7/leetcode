import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        //https://leetcode.com/problems/asteroid-collision/ 735
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.empty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }

                if (st.isEmpty() || st.peek() < 0) {
                    st.add(asteroids[i]);
                } else if (st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                }
            }
            i++;
        }

        int[] aster = new int[st.size()];
        for (i = st.size() - 1; i >= 0; i--) {
            aster[i] = st.pop();
        }

        return aster;
    }
}
