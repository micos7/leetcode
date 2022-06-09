public class RearrangeCharacterstoMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        //https://leetcode.com/problems/rearrange-characters-to-make-target-string/ 2287
        int[] freqS = getFrequencyArray(s);
        int[] freqT = getFrequencyArray(target);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freqT[i] > 0) {
                ans = Math.min(freqS[i] / freqT[i], ans);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    private int[] getFrequencyArray(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
