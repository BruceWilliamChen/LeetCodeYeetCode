package com.bchen.medium.LC36;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/*
 * This solution uses 3 collections to memorize row, col and sub box
 *
 * For each element walked by, check if has been ever existed in:
 *  row
 *  col
 *  or the sub box area it is in
 *  if anything existed return false
 */

public class ValidSodukuSolution2 {
    public boolean isValidSudoku(char[][] board) {
        // let's use hashmap to remember what has been saved

        Map<Integer, Set<Character>> rowRecord = new HashMap<Integer, Set<Character>>();
        Map<Integer, Set<Character>> colRecord = new HashMap<Integer, Set<Character>>();
        // subbox represents as 00, 01, .., 11, .. 22
        Map<String, Set<Character>> subboxRecord = new HashMap<String, Set<Character>>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //check if the current character exists in any recorder
                char currChar = board[i][j];
                String positionsOfSubbox = "" + i/3 + j/3;

                if (currChar != '.') {
                    if (!rowRecord.containsKey(i)) {
                        Set<Character> element = new HashSet<Character>();
                        element.add(currChar);
                        rowRecord.put(i, element);
                    } else {
                        // if contains key, then check if char has exist
                        if (rowRecord.get(i).contains(currChar)) return false;
                        // otherwise add char to the set
                        rowRecord.get(i).add(currChar);
                    }

                    if (!colRecord.containsKey(j)) {
                        Set<Character> element = new HashSet<Character>();
                        element.add(currChar);
                        colRecord.put(j, element);
                    } else {
                        if (colRecord.get(j).contains(currChar)) return false;
                        // otherwise add char to the set
                        colRecord.get(j).add(currChar);
                    }

                    if (!subboxRecord.containsKey(positionsOfSubbox)) {
                        Set<Character> element = new HashSet<Character>();
                        element.add(currChar);
                        subboxRecord.put(positionsOfSubbox, element);
                    } else {
                        if (subboxRecord.get(positionsOfSubbox).contains(currChar)) return false;
                        subboxRecord.get(positionsOfSubbox).add(currChar);
                    }
                }
            }
        }

        // if no break in the loop, meaning all valid
        return true;
    }
}
