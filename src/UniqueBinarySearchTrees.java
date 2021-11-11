public class UniqueBinarySearchTrees {
    private int[] dp = new int[20];
    public int numTrees(int n) {
        //https://leetcode.com/problems/unique-binary-search-trees/ 96
        if(n <=1) return 1;
        if(dp[n] > 0) return dp[n];
        for(int i = 1;i<=n;i++){
            dp[n] += numTrees(i-1) * numTrees(n-i);
        }
        return dp[n];
    }
}
