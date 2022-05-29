package com.bchen.medium.LC73;

import java.util.Set;
import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // need to just remember the initial all rows and columns that need to be set
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // now start to set
        // first try to set all rows that need to be
        for (Integer row: rows) {
            // set all columns in that row
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
        // then set for all cols
        for (Integer col: cols) {
            // set all rows for that col
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }
}
