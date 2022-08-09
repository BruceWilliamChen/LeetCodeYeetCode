package com.bchen.medium.LC15;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) return result;

        //we need to sort this array first
        Arrays.sort(nums);

        //typical 3 sum problem with a little bit modification
        for (int i = 0; i < nums.length - 2; i++) {
            int lowerbound = i + 1, upperbound = nums.length - 1;

            //when lowerbound reaches positive then we can stop
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //this gurantees that if starter the same, we have processed it

            while (upperbound > lowerbound) {
                int sum = nums[i] + nums[lowerbound] + nums[upperbound];
                //when smaller than 0, move lowerbound up; when bigger than 0, move upperbound down
                if (sum < 0) lowerbound++;
                else if (sum > 0) upperbound--;
                else {
                    //when 0, take this triplet
                    Integer[] item = {nums[i], nums[lowerbound], nums[upperbound]};
                    result.add(Arrays.asList(item));
                    //move up and lower until next non-duplicate occurs
                    int baseLower = nums[lowerbound], baseUpper = nums[upperbound];
                    while (upperbound > lowerbound && nums[lowerbound] == baseLower) lowerbound++;
                    while (upperbound > lowerbound && nums[upperbound] == baseUpper) upperbound--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // apply the idea of 2 sums for the rest
            if (nums[i] > 0) return result;

            int lowerbound = i + 1, upperbound = nums.length - 1;
            // for the anchor, skip all dups
            while (i < nums.length - 1 && nums[i] == nums[i+1]) i++;
            while (upperbound > lowerbound) {
                int sum = nums[i] + nums[lowerbound] + nums[upperbound];
                // if sum is smaller than 0, need to increase lowerbound
                if (sum < 0) lowerbound++;
                else if (sum > 0) upperbound--;
                else {
                    // when equal, add to result
                    // IMPORTANT, SKIP ALL DUPLICATES
                    List<Integer> element = new ArrayList<Integer>();
                    element.add(i);
                    element.add(lowerbound);
                    element.add(upperbound);
                    result.add(element);
                    while (upperbound > lowerbound && nums[lowerbound] == nums[lowerbound+1]) lowerbound++;
                    while (upperbound > lowerbound && nums[upperbound] == nums[upperbound-1]) upperbound--;
                    // the following needs to be executed at least once
                    lowerbound++;
                    upperbound--;
                }
            }
        }

        return result;
    }
}
