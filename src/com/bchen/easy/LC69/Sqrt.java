package com.bchen.easy.LC69;

public class Sqrt {
    public int mySqrt(int x) {
        //newton something algorithm
        if (x == 0) return 0;
        if (x == 1) return 1;

        //only return the integer part
        //make sure no out of bound flow, use long

        //start from x's half
        long result = x/2;

        while (result*result > x) {
            result = (result + x/result)/2;
        }
        return (int) result;
    }
}
