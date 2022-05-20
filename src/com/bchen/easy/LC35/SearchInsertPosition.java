package com.bchen.easy.LC35;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int index = 0;

        while (index < nums.length) {
            if (nums[index] == target) return index;
            else if (nums[index] < target) index++;
            else {
                //if bigger than target, then insert to its left
                return index;
            }
        }

        return index;
    }
}
