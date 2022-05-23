package com.bchen.hard.LC42;

/*
 * The point of the puzzle is to find how to calculate the trapped rain water at each elevation
 *
 * From observation, we can conclude that, for each elevation, the unit of water trapped:
 * 1. Find largest elevation of all elevations to its left
 * 2. Find largest elevation of all elevations to its right
 * 3. Find smaller value of the 2 largest of all its left and right
 * 4. Use this value to substract the height of current elevation
 * 5. The result is the unit of water trapped here
 */

/*
 * 2 Solutions
 *
 * One is brute force, for each elevation, walk through the array back and forth twice
 * Time complexity is O(n2)
 *
 * Another one is try to memorize what has been done, dynamic programming
 * Time complexity is O(n)
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];

        leftToRight[0] = height[0];
        for (int i = 1; i < leftToRight.length; i++) {
            leftToRight[i] = Math.max(height[i], leftToRight[i-1]);
        }

        rightToLeft[rightToLeft.length - 1] = height[height.length - 1];
        for (int j = rightToLeft.length - 2; j >= 0; j--) {
            rightToLeft[j] = Math.max(height[j], rightToLeft[j+1]);
        }

        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            int currWater = Math.min(leftToRight[i], rightToLeft[i]) - height[i];
            maxWater += currWater;
        }

        return maxWater;
    }
}
