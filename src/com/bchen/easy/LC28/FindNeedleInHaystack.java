package com.bchen.easy.LC28;

public class FindNeedleInHaystack {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        if (needle.length() == haystack.length()) {
            return needle.equals(haystack)? 0 : -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String part = haystack.substring(i, i+needle.length());
            if (part.equals(needle)) return i;
        }

        return -1;
    }
}
