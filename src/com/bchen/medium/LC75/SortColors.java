package com.bchen.medium.LC75;

public class SortColors {
    public void sortColors(int[] nums) {
        // swap current color with a writer index that moves along the array
        // do this for 3 colors respectively
        int writerIndex = 0;
        // order is 0, 1, 2
        writerIndex = sortBasedOnColor(nums, writerIndex, 0);
        writerIndex = sortBasedOnColor(nums, writerIndex, 1);
        writerIndex = sortBasedOnColor(nums, writerIndex, 2);
    }

    public int sortBasedOnColor(int[] nums, int writerIndex, int color) {
        for (int i = writerIndex; i < nums.length; i++) {
            // whenever found a color, swap with the color at writerIndex, and increase writerIndex
            if (nums[i] == color) {
                int temp = nums[writerIndex];
                nums[writerIndex] = nums[i];
                nums[i] = temp;
                writerIndex++;
            }
        }
        return writerIndex;
    }
}
