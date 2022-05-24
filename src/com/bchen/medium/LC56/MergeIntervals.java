package com.bchen.medium.LC56;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        // sort by start and then start merging
        ArrayList<int[]> container = new ArrayList<int[]>(Arrays.asList(intervals));
        // will be a list of arrays of length 2

        // sort by start
        Collections.sort(container, (a, b) -> a[0] - b[0]);

        int currStart = container.get(0)[0];
        int currEnd = container.get(0)[1];

        for (int i = 1; i < container.size(); i++) {
            // move start until a start is bigger than currEnd
            if (container.get(i)[0] <= currEnd) {
                // also need to updateEnd to be the max
                currEnd = Math.max(currEnd, container.get(i)[1]);
                continue;
            }
            // when hit a start is bigger than end from previous
            // add a new entry to result
            int[] element = new int[2];
            element[0] = currStart;
            element[1] = currEnd;
            result.add(element);
            // update currStart and currEnd
            currStart = container.get(i)[0];
            currEnd = container.get(i)[1];
        }
        // need to add start and end one more time outta loop
        int[] element = new int[2];
        element[0] = currStart;
        element[1] = currEnd;
        result.add(element);

        return result.toArray(new int[result.size()][]);
    }
}
