import java.util.HashMap;

public class FibonacciNumber {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        //https://leetcode.com/problems/fibonacci-number/ 509
        if (n <= 1) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int v = fib(n - 1) + fib(n - 2);
        cache.put(n, v);
        return cache.get(n);
    }
}
