package com.bchen.medium.LC05;

/*
 * The idea is to find either even length of odd length
 *
 * Pick a character and expand to both directions
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        //start from the middle, expand to both directions
        if (s == null || s.length() == 0) return "";

        int left = 0, right = 0; //they are two boundaries

        for (int i = 0; i < s.length(); i++) {
            int oddMax = expand(s, i, i);
            int evenMax = expand(s, i, i + 1);
            int max = Math.max(oddMax, evenMax);

            //if max is bigger than left - right, update left and right
            if (max > (right - left)) {
                left = i - (max - 1)/2;
                right = i + max/2;
            }
        }
        return s.substring(left, right + 1);
    }

    public int expand(String s, int left, int right) {
        //if left and right equal then it means the it expands from one point
        //if not equal then expands from two points
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
