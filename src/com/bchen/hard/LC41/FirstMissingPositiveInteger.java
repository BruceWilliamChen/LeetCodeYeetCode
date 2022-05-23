package com.bchen.hard.LC41;

/*
 * The trick of the puzzle is to find that answer will always lie between 1 to nums.length+1
 *
 * So to reduce this, we just need to find, which number in this range, does not present in the original array
 *
 * Since we have to use O(n) and no extra space, we need to somehow, use the original array:
 * 1. If value out of range, meaning, <= 0 or >= nums.length + 1, we do not care
 * 2. If value in range, then we now see it in another way, to be an index of this array
 *  i. we go to the array and mark the value of this "index" to be something
 *  ii. later we go through this array again, and evaluate value at each index
 *  iii. if value is this marker thing, we know it has been seen, otherwise, it is the result
 *
 * Marker we use is to mark that value negative.
 * This would require us to first convert all naturally negative values to a positive value we can ignore, the upperbound
 * Also to make sure same value will not "unmark" the value, we only mark value to negative if it is positive
 * Whenever we walk though a value, we take absolute, because it could originally be in range, but marked
 * by other values.
 */

public class FirstMissingPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= nums.length) {
                int newVal = nums[val - 1];
                if (newVal > 0) nums[val - 1] = newVal*-1;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0) return i;
        }

        return nums.length + 1;
    }
}
