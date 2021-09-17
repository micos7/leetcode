public class Numberof1Bits {
    public int hammingWeight(int n) {
        //https://leetcode.com/problems/number-of-1-bits/ 191
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        //optimized
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
