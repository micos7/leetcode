public class CountPrimes {
    public int countPrimes(int n) {
        //https://leetcode.com/problems/count-primes/ 204
        int[] primes = new int[n];
        int count = 0;

        for (int i = 2; i * i < n; i++) {
            if (primes[i] == 0) {
                for (int j = i; j * i < n; j++) {
                    primes[i * j] = 1;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) count++;
        }

        return count;
    }
}
