import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
        char[] sarr = s.toCharArray();
        Set<Integer> invalidIndices = new HashSet<Integer>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sarr.length; i++) {
            char c = sarr[i];
            if (c == '(') {
                st.add(i);
            } else if (c == ')') {
                if (st.isEmpty()) invalidIndices.add(i);
                else st.pop();
            }
        }

        while (!st.isEmpty()) invalidIndices.add(st.pop());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sarr.length; i++) {
            if (!invalidIndices.contains(i)) {
                sb.append(sarr[i]);
            }
        }

        return sb.toString();
    }
}
