package com.bchen.medium.LC55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // dynamic programming
        // calculate to each position
        // so far to this position, what is the furthest possible that can get
        // and store that
        // also as long as we find any spot that can jump to the end, we can return true
        // since we always just consider furthest, so greedy algo

        int[] dp = new int[nums.length];

        dp[0] = Math.max(nums[0] + 0, 0);
        for (int i = 1; i < nums.length; i++) {
            // either furthest from all its left, or itself
            // furthest so far
            if (dp[i - 1] < i) return false; // meaning this point in unreachable;
            dp[i] = Math.max(dp[i-1], nums[i] + i); // furthest to reach from this point
            if (dp[i] >= nums.length - 1) return true;
        }
        // if no interruption in between, meaning always reachable
        return true;
    }
}
