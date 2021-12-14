public class ConsecutiveCharacters {
    public int maxPower(String s) {
        //https://leetcode.com/problems/consecutive-characters/ 1446
        int[] chars = new int[26];
        int max = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
