public class MinimumWindowSubstring {
    //https://leetcode.com/problems/minimum-window-substring/ 76
    public String minWindow(String s, String t) {
        if(t== null || s == null)
            return "";

        String res ="";
        int[] letters = new int[128];
        int left =0, count = 0, minLen = Integer.MAX_VALUE;

        for(char c: t.toCharArray()){
            ++letters[c];
        }

        for(int right = 0;right<s.length();right++){
            if(--letters[s.charAt(right)] >= 0 ){
                ++count;
            }
            while(count == t.length()){
                if(minLen > right - left+1){
                    minLen = right - left+1;
                    res = s.substring(left,right+1);
                }
                if(++letters[s.charAt(left)] > 0)
                    --count;
                ++left;
            }
        }

        return res;
    }
}
