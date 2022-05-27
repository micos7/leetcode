public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        //https://leetcode.com/problems/valid-parenthesis-string/ 678
        int b = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                b++;
            } else {
                b--;
            }
            if (b < 0) return false;
        }

        if (b == 0) return true;

        b = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                b++;
            } else {
                b--;
            }
            if (b < 0) return false;
        }

        return true;
    }
}
