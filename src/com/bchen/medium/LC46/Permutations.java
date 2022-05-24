package com.bchen.medium.LC46;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // basically backtracking
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        DFS(result, new ArrayList<Integer>(), nums, new HashSet<Integer>());
        return result;
    }

    public void DFS(List<List<Integer>> result, List<Integer> element, int[] nums, Set<Integer> passedIndex) {
        if (passedIndex.size() == nums.length) {
            // add element to result
            result.add(element);
        }

        // otherwise keep going
        for (int i = 0; i < nums.length; i++) {
            if (passedIndex.contains(nums[i])) continue;
            // if not, then add that, make new list, keep going
            Set<Integer> newPassedIndex = new HashSet<Integer>(passedIndex);
            newPassedIndex.add(nums[i]);
            List<Integer> newElement = new ArrayList<Integer>(element);
            newElement.add(nums[i]);
            DFS(result, newElement, nums, newPassedIndex);
        }
    }
}
