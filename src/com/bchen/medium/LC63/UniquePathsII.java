package com.bchen.medium.LC63;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];

        cache[0][0] = obstacleGrid[0][0] == 1? 0 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) cache[i][j] = 0;
                else {
                    if (i == 0) cache[i][j] = cache[i][j-1];
                    else if (j == 0) cache[i][j] = cache[i-1][j];
                    else cache[i][j] = cache[i-1][j] + cache[i][j-1];
                }
            }
        }

        return cache[cache.length - 1][cache[0].length - 1];
    }
}
