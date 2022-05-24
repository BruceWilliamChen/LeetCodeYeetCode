package com.bchen.medium.LC54;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        //simulate the whole process
        List<Integer> result = new ArrayList<Integer>();

        if (matrix.length == 0) return result;

        int rowPosition = 0, colPosition = 0;
        //it is always, right -> down -> left -> up, and repeat until
        int rowTerminate = matrix.length - 1, colTerminate = matrix[0].length - 1;

        while (rowPosition <= rowTerminate && colPosition <= colTerminate) {
            //move right
            for (int i = colPosition; i <= colTerminate; i++) {
                result.add(matrix[rowPosition][i]);
            }
            //when right is done, it means next time row should be terminated one more position above
            rowPosition++;

            //move down
            for (int i = rowPosition; i <= rowTerminate; i++) {
                result.add(matrix[i][colTerminate]);
            }
            //when down is done, it means, nex time the col end should be shifted to the left
            colTerminate--;

            //move left, and have to check if it's possible to move left
            if (rowTerminate >= rowPosition) {
                for (int i = colTerminate; i >= colPosition; i--) {
                    result.add(matrix[rowTerminate][i]);
                }
            }
            //when done, then row terminate should be one less
            rowTerminate--;

            //move up
            if (colTerminate >= colPosition) {
                for (int i = rowTerminate; i >= rowPosition; i--) {
                    result.add(matrix[i][colPosition]);
                }
            }
            //when done then col start is one ahead
            colPosition++;
        }
        //finally return the result
        return result;
    }
}
