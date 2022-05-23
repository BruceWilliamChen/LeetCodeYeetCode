package com.bchen.medium.LC39;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // typical backtracking problem
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        deepFirstSearch1(candidates, target, result, new ArrayList<Integer>(), 0, 0);
        // deepFirstSearch2(candidates, target, result, new ArrayList<Integer>(), 0, 0);

        return result;
    }

    public void deepFirstSearch1(int[] candidates, int target, List<List<Integer>> result, List<Integer> element, int startingIndex, int pathSum) {
        if (pathSum == target) {
            result.add(element);
            return;
        }
        if (pathSum > target) return;

        // now go from current index to one element after
        for (int i = startingIndex; i < candidates.length; i++) {
            // create brand new object so that no need to modify current object
            List<Integer> newElem = new ArrayList<Integer>(element);
            newElem.add(candidates[i]);
            int newPathSum = pathSum + candidates[i];
            this.deepFirstSearch1(candidates, target, result, newElem, i, newPathSum);
        }
    }

    public void deepFirstSearch2(int[] candidates, int target, List<List<Integer>> result, List<Integer> element, int startingIndex, int pathSum) {
        if (pathSum == target) {
            // when match, take all elemennts out and add it to result
            // should not use the object directly because it keeps being modified
            List<Integer> matched = new ArrayList<Integer>(element);
            result.add(matched);
            return;
        }
        if (pathSum > target) return;

        // now go from current index to one element after
        for (int i = startingIndex; i < candidates.length; i++) {
            // modify currrent object, but reset after recursive calls
            element.add(candidates[i]);
            pathSum = pathSum + candidates[i];
            this.deepFirstSearch2(candidates, target, result, element, i, pathSum);
            // reset
            element.remove(element.size() - 1);
            pathSum = pathSum - candidates[i];
        }
    }
}
