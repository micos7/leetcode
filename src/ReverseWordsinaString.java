import java.util.Stack;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        //https://leetcode.com/problems/reverse-words-in-a-string/ 151
        char[] ar = s.toCharArray();
        Stack<String> st = new Stack<>();
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && ar[i] == ' ') {
                i++;
            }

            while (i < s.length() && ar[i] != ' ') {
                word += ar[i];
                i++;
            }
            st.push(word);
            word = "";
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans += st.pop() + ' ';
        }

        return ans.trim();
    }
}
