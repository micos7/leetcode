public class Pow {
    public double myPow(double x, int n) {
        //https://leetcode.com/problems/powx-n/ 50
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;

        double half = pow(x, n / 2);
        if (n % 2 == 0) return half * half;

        return half * half * x;
    }
}
