import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        //https://leetcode.com/problems/letter-case-permutation/ 784
        List<String> ans = new ArrayList<>();
        traverse(0,ans,new StringBuilder(s));
        return ans;
    }

    private void traverse(int index,List<String> ans,StringBuilder sb){
        if(index ==sb.length()){
            ans.add(sb.toString());
            return;
        }
        if (Character.isDigit(sb.charAt(index))) {
            traverse(index+1, ans,sb);
            return;
        }

        sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));
        traverse(index+1, ans,sb);
        sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));
        traverse(index+1, ans,sb);
    }
}
