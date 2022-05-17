public class Largest3SameDigitNumberinString {
    public String largestGoodInteger(String num) {
        //https://leetcode.com/problems/largest-3-same-digit-number-in-string/ 2264
        int start = 0;
        int i = 0;
        int digit = -1;

        while (i < num.length()) {
            if (i + 1 < num.length() && num.charAt(i) == num.charAt(i + 1)) {
                i++;
                continue;
            } else {
                int len = i - start + 1;
                if (len >= 3) {
                    digit = Math.max(digit, num.charAt(start) - '0');
                }
                start = i + 1;
                i++;
            }
        }

        if (digit != -1) {
            return digit + "" + digit + "" + digit;
        }

        return "";
    }
}
