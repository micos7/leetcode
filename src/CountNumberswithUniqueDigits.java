public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        //https://leetcode.com/problems/count-numbers-with-unique-digits/ 357
        if (n == 0) return 1;
        int ans = 10;
        int start = 9;
        int current = 9;

        while (n-- > 1 && start > 0) {
            current *= start--;
            ans += current;
        }
        return ans;
    }
}
