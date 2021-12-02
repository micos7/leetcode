public class RotateString {
    public boolean rotateString(String s, String goal) {
        //https://leetcode.com/problems/rotate-string/ 796
        if (s.length() != goal.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s + s);
        return sb.toString().indexOf(goal) != -1;
    }
}
