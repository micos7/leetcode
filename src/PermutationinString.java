public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        //https://leetcode.com/problems/permutation-in-string/ 567
        int[] table = new int[26];

        int L = 0, R = 0;
        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();

        for (char c : s1a) {
            table[c - 'a']++;
        }

        int minLen = Integer.MAX_VALUE;
        int count = 0;

        while (R < s2a.length) {
            char cur = s2a[R];
            if (--table[cur - 'a'] >= 0) count++;

            while (count == s1.length()) {
                int curLen = R - L + 1;
                minLen = Math.min(curLen, minLen);
                char leftChar = s2a[L];
                if (++table[leftChar - 'a'] > 0) {
                    count--;
                }
                L++;
            }
            R++;
        }
        return minLen == s1.length();
    }
}
