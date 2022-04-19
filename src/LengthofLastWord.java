public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        //https://leetcode.com/problems/length-of-last-word/ 58
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count > 0) return count;
            if (s.charAt(i) != ' ') count++;
        }
        return count;
    }
}
