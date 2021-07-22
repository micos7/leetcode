import java.util.List;

public class WordBreak {
    //https://leetcode.com/problems/word-break/ 139
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] b = new boolean[s.length() +1];

        b[0] = true;

        for(int i = 0;i< s.length()+1;i++){
            for(int j = 0;j<i;j++ ){
                if(b[j] && wordDict.contains(s.substring(j,i))){
                    b[i] = true;
                    break;
                }
            }
        }

        return b[s.length()];
    }
}
