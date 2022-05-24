package com.bchen.easy.LC26;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        //two pointers
        if (nums == null || nums.length == 0) return 0;

        int writer = 0, reader = 0;
        int anchor = 0;

        while (reader < nums.length) {
            if (nums[reader] == nums[anchor]) {
                reader++;
            } else {
                writer++;
                nums[writer] = nums[reader];
                anchor = reader;
            }
        }
        //finally return the position of writer
        return writer + 1;
    }
}
