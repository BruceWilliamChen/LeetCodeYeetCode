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

    public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);

        // very similar to 3 sum, just keep track of closet
        int distance = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int lowerbound = i + 1, upperbound = nums.length - 1;
            while (upperbound > lowerbound) {
                int sum = nums[lowerbound] + nums[upperbound] + nums[i];
                int diff = Math.abs(target - sum);
                if (diff == 0) return sum;
                if (diff <= distance) {
                    distance = diff;
                    result = sum;
                }
                // then move cursor based on sum
                if (sum < target) lowerbound++;
                else upperbound--;
            }
        }

        return result;
    }
}
