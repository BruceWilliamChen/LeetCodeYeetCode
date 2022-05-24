package com.bchen.hard.LC32;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) == '(') dp[i] = 0;
            else if (i > 1 && s.charAt(i-2) == '(') dp[i] = dp[i-2]+2;
            else if (i-1 > dp[i-1] && s.charAt(i-2) == ')' &&  s.charAt(i-2-dp[i-1]) == '(')
                dp[i] = dp[i-1]+2+dp[i-2-dp[i-1]];
            if (dp[i]>max) max=dp[i];
        }
        return max;
    }
}
