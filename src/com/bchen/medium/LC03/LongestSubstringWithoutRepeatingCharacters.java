package com.bchen.medium.LC03;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> record = new HashSet<Character>();

        int lowerEnd = 0, upperEnd = 0, maxLength = 0;

        while (upperEnd < s.length()) {
            char currentChar = s.charAt(upperEnd);
            if (!record.contains(currentChar)) {
                record.add(currentChar);
                maxLength = Math.max(maxLength, upperEnd - lowerEnd);
                upperEnd += 1;
            } else {
                // when hit duplicate
                char check = s.charAt(lowerEnd);
                while (record.contains(check) && lowerEnd < s.length()) {
                    record.remove(check);
                    lowerEnd += 1;
                }
            }
        }

        return maxLength + 1;
    }
}
