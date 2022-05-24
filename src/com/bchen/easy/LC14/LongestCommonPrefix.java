package com.bchen.easy.LC14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder longestCommonPrefix = new StringBuilder();

        String baseWord = strs[0];

        //then iterate through the rest of the words
        for (int i = 0; i < baseWord.length(); i++) {
            char baseChar = baseWord.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String compareWord = strs[j];
                //current char index out of range for current word
                if (i >= compareWord.length()) return longestCommonPrefix.toString();
                //current char is not euqal to base
                if (compareWord.charAt(i) != baseChar) return longestCommonPrefix.toString();
            }
            //if all word pass check, add that char to the result
            longestCommonPrefix.append(baseChar);
        }

        return longestCommonPrefix.toString();
    }
}
