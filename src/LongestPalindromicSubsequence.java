public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        //https://leetcode.com/problems/longest-palindromic-subsequence/ 516
        int l = s.length();
        int[][] dp = new int[l][l];

        for(int i = l-1;i>=0;i--){
            dp[i][i] =1;
            for(int j = i+1;j<l;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        return dp[0][l-1];
    }
}
