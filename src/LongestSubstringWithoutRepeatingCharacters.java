import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/ 3
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        HashSet<Character> hs = new HashSet<Character>();

        while (right < s.length()) {
            if (!hs.contains(s.charAt(right))) {
                hs.add(s.charAt(right));
                right++;
                max = Math.max(max, hs.size());
            } else {
                hs.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
