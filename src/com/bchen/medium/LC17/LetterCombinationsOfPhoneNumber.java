package com.bchen.medium.LC17;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public static String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();

        if (digits == null || digits.length() == 0) return results;

        findAllCombos(digits, new StringBuilder(), results, 0);

        return results;
    }

    public void findAllCombos(String digits, StringBuilder prev, List<String> results, int position) {
        if (position == digits.length()) {
            results.add(prev.toString());
            return;
        }
        String digitLetters = LetterCombinationsOfPhoneNumber.letters[Character.getNumericValue(digits.charAt(position)) - 2];

        for (int i = 0; i < digitLetters.length(); i++) {
            char currChar = digitLetters.charAt(i);
            StringBuilder temp = new StringBuilder(prev.toString()).append(currChar);
            findAllCombos(digits, temp, results, position+1);
        }
    }
}
