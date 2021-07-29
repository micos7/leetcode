public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // https://leetcode.com/problems/longest-palindromic-substring/ 5
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;


        for (int i = 0; i < s.length(); i++) {
            int lenMiddle = expand(s, i, i);
            int lenAsymetrical = expand(s, i, i + 1);
            int maxLen = Math.max(lenMiddle, lenAsymetrical);
            if (maxLen > end - start) {
                start = i - ((maxLen - 1) / 2);
                end = i + maxLen / 2;
            }

        }

        return s.substring(start, end + 1);
    }

    public int expand(String s, int left, int right) {
        if (s == null || left > right) return 0;


        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
