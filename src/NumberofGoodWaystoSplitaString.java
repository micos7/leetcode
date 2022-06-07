public class NumberofGoodWaystoSplitaString {
    public int numSplits(String s) {
        //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/ 1525
        int[] cntr = new int[26];
        int[] cntl = new int[26];
        int charsl = 0;
        int charsr = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (++cntr[c - 'a'] == 1) {
                charsr++;
            }
        }
        for (char c : s.toCharArray()) {
            if (++cntl[c - 'a'] == 1) {
                charsl++;
            }
            if (--cntr[c - 'a'] == 0) {
                charsr--;
            }
            if (charsl == charsr) {
                ans++;
            }
        }

        return ans;
    }
}
