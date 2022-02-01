import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //https://leetcode.com/problems/palindrome-partitioning/ 131
        List<List<String>> ans = new ArrayList<>();
        traverse(s, 0, ans, new ArrayList<String>());
        return ans;
    }

    private void traverse(String s, int index, List<List<String>> ans, List<String> temp) {
        if (s.length() == index) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                traverse(s, i + 1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
