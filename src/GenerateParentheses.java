import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        //https://leetcode.com/problems/generate-parentheses/ 22
        List<String> ans = new ArrayList<>();
        traverse(ans, "",0,0,n);
        return ans;
    }
    private void traverse(List<String> ans, String cur,int open,int close, int length){
        if(cur.length() == length *2){
            ans.add(cur);
            return;
        }
        if(open < length) traverse(ans,cur+"(", open+1,close,length);
        if(close < open) traverse(ans,cur+")", open,close+1,length);
    }
}
