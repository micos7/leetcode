public class CheckifNumberHasEqualDigitCountandDigitValue {
    public boolean digitCount(String num) {
        //https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/ 2283
        int[] cnt = new int[11];
        char[] charArr = num.toCharArray();
        for (char d : charArr) {
            ++cnt[d - '0'];
        }
        for (int i = 0; i < charArr.length; ++i) {
            if (cnt[i] != charArr[i] - '0') {
                return false;
            }
        }
        return true;
    }
}
