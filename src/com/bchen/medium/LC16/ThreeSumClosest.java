package com.bchen.medium.LC16;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;

        Arrays.sort(nums);

        int distance = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int lower = i + 1;
            int upper = nums.length - 1;

            while (lower < upper) {
                int sum = nums[lower] + nums[upper] + nums[i];
                int diff = Math.abs(sum - target);
                if (diff == 0) return sum;
                if (diff <= distance) {
                    distance = diff;
                    result = sum;
                }
                if (sum < target) {
                    //move lower end
                    lower++;
                } else {
                    upper--;
                }
            }
        }

        return result;
    }
}
