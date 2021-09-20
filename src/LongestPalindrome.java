public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //https://leetcode.com/problems/longest-palindrome/ 409
        int char_counts[] = new int[128];
        int result = 0;
        for (char c : s.toCharArray()) {
            char_counts[c]++;
        }

        for (Integer char_count : char_counts) {
            result += char_count / 2 * 2;
            if (result % 2 == 0 && char_count % 2 == 1) {
                result += 1;
            }
        }

        return result;
    }
}
