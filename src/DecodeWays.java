public class DecodeWays {
    public int numDecodings(String s) {
        //https://leetcode.com/problems/decode-ways/ 91
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int digit = Integer.valueOf(s.substring(i - 1, i));
            int digits = Integer.valueOf(s.substring(i - 2, i));

            if (digit >= 1)
                dp[i] += dp[i - 1];

            if (digits >= 10 && digits <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }
}
