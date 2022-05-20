package com.bchen.medium.LC34;

public class FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums == null || nums.length == 0) return result;

        int index = 0;

        while (index < nums.length) {
            if (nums[index] < target) index++;
            else if (nums[index] > target) break;
            else {
                result[0] = index;
                while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
                    index++;
                }
                result[1] = index;
                break;
            }
        }

        return result;
    }
}
