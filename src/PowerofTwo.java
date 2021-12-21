public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        //https://leetcode.com/problems/power-of-two/ 231
        long i = 1;
        while (i < n) {
            i *= 2;
        }
        return i == n;
    }
}
