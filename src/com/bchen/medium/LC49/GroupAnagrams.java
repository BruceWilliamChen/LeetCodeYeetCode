package com.bchen.medium.LC49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> holder = new HashMap<String, List<String>>();

        if (strs.length == 0 || strs == null) return result;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (holder.containsKey(sortedStr)) holder.get(sortedStr).add(str);
            else {
                holder.put(sortedStr, new ArrayList<String>(Arrays.asList(str)));
            }
        }

        for (Map.Entry<String, List<String>> entry : holder.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
