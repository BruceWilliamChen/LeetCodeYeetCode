package com.bchen.medium.LC45;

public class JumpGameII {
    public int jump(int[] nums) {
        // greedy algorithms
        // go from the end, for each position, we just try to find, if from start, any position can one jump reach current
        // if so, we use it, and we now do the same thing for that position
        return greedySearch(nums, nums.length - 1, 0);
    }

    public int greedySearch(int[] nums, int currentPosition, int countOfSteps) {
        if (currentPosition == 0) return countOfSteps;

        // otherwise keep going
        for (int i = 0; i < currentPosition; i++) {
            if (nums[i] + i >= currentPosition) {
                countOfSteps++;
                currentPosition = i;
                break;
            }
        }
        return greedySearch(nums, currentPosition, countOfSteps);
    }
}
