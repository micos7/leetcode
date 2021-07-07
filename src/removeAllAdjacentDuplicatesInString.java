import java.util.Stack;

public class removeAllAdjacentDuplicatesInString {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/ 1047
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (st.size() > 0 && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
