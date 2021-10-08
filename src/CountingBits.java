public class CountingBits {
    public int[] countBits(int n) {
        //https://leetcode.com/problems/counting-bits/ 338
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i >> 1] + i % 2;
        }
        return count;
    }
}
