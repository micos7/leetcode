public class ClimbingStairs {
    //https://leetcode.com/problems/climbing-stairs/ 70
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return recurse(n, cache);
    }

    private int recurse(int n, int[] cache) {
        if (cache[n] > 0) {
            return cache[n];
        }

        if (n <= 1) {
            return 1;
        }
        cache[n] = recurse(n - 1, cache) + recurse(n - 2, cache);

        return cache[n];
    }
}
