public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        //https://leetcode.com/problems/expressive-words/ 809
        int res = 0;
        for (String word : words) {
            if (expressive(S, word)) res++;
        }
        return res;
    }

    private boolean expressive(String S, String word) {

        if (word.length() > S.length()) return false;

        int p1 = 0, p2 = 0;

        while (p1 < S.length() && p2 < word.length()) {

            if (S.charAt(p1) != word.charAt(p2)) return false;

            //count each letter
            int c1 = 0, c2 = 0;
            char ch = S.charAt(p1);

            while (p1 < S.length() && S.charAt(p1) == ch) {
                c1++;
                p1++;
            }

            while (p2 < word.length() && word.charAt(p2) == ch) {
                c2++;
                p2++;
            }

            if ((c2 > c1) || (c1 < 3 && c1 != c2)) return false;

        }

        if (p1 < S.length() || p2 < word.length()) return false;

        return true;
    }
}
