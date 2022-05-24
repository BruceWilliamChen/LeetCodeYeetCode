package com.bchen.medium.LC62;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // DP
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //at any point, can only be moved from left or up
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
