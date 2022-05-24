package com.bchen.easy.LC53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // for each index, the largest sum so far, is the larger between: the largest sum from all left + iteself, or just itself (itself needs be included, so can't be all left)
        // so naturally we know to use dynamic programming
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
