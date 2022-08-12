import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        //https://leetcode.com/problems/remove-outermost-parentheses/ 1021
        StringBuilder sb = new StringBuilder();
        int start = 0;
        Stack<Character> stck = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);

            if (!stck.isEmpty() && stck.peek() == '(' && c == ')') {
                stck.pop();
            } else {
                stck.push(c);
            }
            if (stck.isEmpty()) {

                sb.deleteCharAt(start);
                sb.deleteCharAt(sb.length() - 1);
                start = sb.length();
            }
        }
        return sb.toString();
    }
}
