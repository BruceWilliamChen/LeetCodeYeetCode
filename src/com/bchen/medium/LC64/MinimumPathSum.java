package com.bchen.medium.LC64;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // use dynamic programming technique
        // for each spot, minimum sum must be from the smaller from up or left plus itself

        int[][] cache = new int[grid.length][grid[0].length];
        cache[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;

                if (i == 0) {
                    // first row
                    cache[i][j] = cache[i][j-1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    // first column
                    cache[i][j] = cache[i-1][j] + grid[i][j];
                    continue;
                }
                // otherwise calculate smaller from up and left plus itself
                cache[i][j] = Math.min(cache[i-1][j], cache[i][j-1]) + grid[i][j];
            }
        }

        return cache[cache.length - 1][cache[0].length - 1];
    }
}
