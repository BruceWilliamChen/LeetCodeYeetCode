package com.bchen.easy.LC66;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carryOver = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int currNum = digits[i];
            carryOver = (currNum + 1)/10;
            digits[i] = (currNum + 1)%10;
            // if carryOver is 0, meaning we can stop
            if (carryOver == 0) break;
        }

        // if digits exhausted, and we still have carry over, then make a new array
        if (carryOver == 0) return digits;
        int[] result = new int[digits.length + 1];
        result[0] = carryOver;
        for (int i = 0; i < digits.length; i++) {
            result[i+1] = digits[i];
        }

        return result;
    }
}
