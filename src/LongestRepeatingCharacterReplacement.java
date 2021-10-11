import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //https://leetcode.com/problems/longest-repeating-character-replacement/ 424
        char[] ar = s.toCharArray();
        int left = 0, right = 0, n = ar.length;

        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0, mostFreq = 0;

        while (right < n) {
            m.put(ar[right], m.getOrDefault(ar[right], 0) + 1);
            mostFreq = Math.max(mostFreq, m.get(ar[right]));

            if ((right - left + 1) - mostFreq > k) {
                m.put(ar[left], m.get(ar[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
