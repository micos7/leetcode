public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        //https://leetcode.com/problems/valid-palindrome-ii/ 680
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return check(s, left + 1, right) || check(s, left, right - 1);
            left++;
            right--;
        }

        return true;
    }

    public boolean check(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
