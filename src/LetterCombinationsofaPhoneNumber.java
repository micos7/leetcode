import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/ 17
    List<String> ans =null ;
    String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        dfs(0,digits,new StringBuilder());
        return ans;
    }

    void dfs(int length,String digits,StringBuilder sb){
        if(length == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char ch = digits.charAt(length);
        String s = map[ch-'0'];
        for(char c:s.toCharArray()){
            sb.append(c);
            dfs(length+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
