public class CustomSortString {
    public String customSortString(String order, String str) {
        //https://leetcode.com/problems/custom-sort-string/ 791
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder resp = new StringBuilder();

        for (char o : order.toCharArray()) {
            while (freq[o - 'a'] > 0) {
                resp.append(o);
                freq[o - 'a']--;
            }
        }


        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                resp.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return resp.toString();
    }
}
