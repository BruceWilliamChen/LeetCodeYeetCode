package com.bchen.LC01;
import java.util.HashMap;
import java.util.Map;

/*
  Brute force: O(n^2)
  -> For each number in the input list, iterate through the list all over again.
     If satisfying summation equal to the target, return.

  Optimal: O(n)
  1. Create a map
  2. For each number in the input list, calculate its complement against the target sum.
     Check the map to see if the complement is already a key.
     if not a key:
        Store this complement as key in the map, value to be the current index of this number.
     else
        Create a result array of length 2, [0] is the current index, [1] is the value associated with the key.
 */



public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToComplement = new HashMap<Integer, Integer>();

        int[] result = new int[2];

        //handle exception
        if (nums.length == 0 || nums == null) return result;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numberToComplement.containsKey(nums[i])) {
                result[0] = i;
                result[1] = numberToComplement.get(nums[i]);
            } else {
                numberToComplement.put(complement, i);
            }
        }
        return result;
    }
}
