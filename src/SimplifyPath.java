import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        //https://leetcode.com/problems/simplify-path/ 71
        Stack<String> s = new Stack<>();
        for (String ss : path.split("/")) {
            if (ss.equals("") || ss.equals(".")) {
                continue;
            } else if (ss.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.add(ss);
            }
        }

        return "/" + String.join("/", s);
    }
}
