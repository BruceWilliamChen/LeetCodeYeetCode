package com.bchen.medium.LC36;
import java.util.Set;
import java.util.HashSet;

/*
 * This is the brute force soltution
 * Traverse all rows, cols and subboxes to make sure they are all valid
 *
 * This solution works because we are only looking at a 9x9 size of 2D array
 * So brute force won't be bad at all
 *
 * Time complexity is O(9x9) x 3
 */

public class ValidSodukuSolution1 {
    public boolean isValidSudoku(char[][] board) {
        //validate regions, rows and columns
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            if (!this.validateRow(row)) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!this.validateColumn(board, i)) return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int xStart = i*3;
                int yStart = j*3;

                if (!this.validateRegion(xStart, yStart, board)) return false;
            }
        }

        return true;
    }

    public boolean validateRow(char[] row) {
        Set<Character> rowChars = new HashSet<Character>();
        for (int column = 0; column < 9; column++) {
            if (row[column] == '.') continue;

            if (!rowChars.contains(row[column])) rowChars.add(row[column]);
            else return false;
        }
        return true;
    }

    public boolean validateColumn(char[][] board, int column) {
        Set<Character> columnChars = new HashSet<Character>();
        for (int row = 0; row < 9; row++) {
            if (board[row][column] == '.') continue;

            if (!columnChars.contains(board[row][column])) columnChars.add(board[row][column]);
            else return false;
        }
        return true;
    }

    public boolean validateRegion(int x, int y, char[][] board) {
        //subbox is also length of 3
        Set<Character> boxChars = new HashSet<Character>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char elem = board[x+i][y+j];
                if (elem == '.') continue;

                if (!boxChars.contains(elem)) boxChars.add(elem);
                else return false;
            }
        }

        return true;
    }
}
