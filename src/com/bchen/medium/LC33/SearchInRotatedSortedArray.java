package com.bchen.medium.LC33;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;

        //because now it is first desceding then ascending, or the opposite

        //first find the spot where the pivot is located using binary search

        int lowerBound = 0, upperBound = nums.length - 1;

        if (nums[lowerBound] == target) return lowerBound;
        if (nums[upperBound] == target) return upperBound;

        while (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound)/2;

            if (target == nums[mid]) return mid;

            //try to check, up to this mid
            //if left are all asceding, or right are all ascending
            if (nums[mid] > nums[lowerBound]) {
                //then check to see if target is within this left part
                if (target > nums[lowerBound] && target < nums[mid]) upperBound = mid;
                else lowerBound = mid + 1;
            } else {
                if (target < nums[upperBound] && target > nums[mid]) lowerBound = mid + 1;
                else upperBound = mid;
            }
            if (nums[lowerBound] == target) return lowerBound;
            if (nums[upperBound] == target) return upperBound;
        }

        return -1;
    }
}
