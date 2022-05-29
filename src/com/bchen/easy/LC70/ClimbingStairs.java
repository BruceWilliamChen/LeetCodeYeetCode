package com.bchen.easy.LC70;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // classic dp
        int[] cache = new int[n+1];

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;

        // for each nth stair, the number of ways it takes to get here is equal to
        // number of ways to get n-1 stair plus number of ways to get n-2 stair

        for (int i = 3; i < n+1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[cache.length - 1];
    }
}
