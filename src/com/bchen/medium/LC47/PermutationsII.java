package com.bchen.medium.LC47;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, used, res, list);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, used, res, list);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
