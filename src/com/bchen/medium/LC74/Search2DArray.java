package com.bchen.medium.LC74;

public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null) return false;

        int possibleRow = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] < target) continue;
            else if (matrix[i][matrix[0].length - 1] == target) return true;
            else {
                possibleRow = i;
                break;
            }
        }

        if (possibleRow < 0) return false;

        return binarySearch(0, matrix[possibleRow].length, matrix[possibleRow], target);
    }

    public boolean binarySearch(int lowerBound, int upperBound, int[] possibleRow, int target) {
        while (upperBound > lowerBound) {
            int mid = (lowerBound + upperBound)/2;
            if (possibleRow[mid] == target) return true;
            else if (possibleRow[mid] > target) upperBound = mid;
            else lowerBound = mid + 1;
        }

        return false;
    }
}
