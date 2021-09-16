public class ReverseBits {
    public int reverseBits(int n) {
        //https://leetcode.com/problems/reverse-bits/ 190
        int res = 0;
        boolean isSigned = n < 0 ? true : false;
        int val = 31;
        while (val-- > 0) {
            res |= (n & 1);
            n = n >> 1;
            res = res << 1;
        }
        return isSigned ? res + 1 : res;

    }
}
