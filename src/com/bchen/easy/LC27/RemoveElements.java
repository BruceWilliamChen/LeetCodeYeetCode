package com.bchen.easy.LC27;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter++] = nums[i];
            }
        }

        return counter;
    }
}
