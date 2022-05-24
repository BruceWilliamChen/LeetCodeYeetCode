package com.bchen.medium.LC11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int start = 0, end = height.length - 1;
        int maxArea = (end - start)*Math.min(height[start], height[end]);

        while (end > start) {
            if (height[end] > height[start]) start++;
            else end--;

            maxArea = Math.max(maxArea, (end - start)*Math.min(height[start], height[end]));
        }
        return maxArea;
    }
}
