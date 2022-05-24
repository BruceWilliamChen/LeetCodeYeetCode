package com.bchen.medium.LC07;

public class ReverseInteger {
    public int reverse(int x) {
        //easy way to check overflow is

        /*
            if int a overflows, then (a%10) + a/10 != a
        */

        if (x == 0 || x == 1) return x;

        int sum = 0;

        while (x != 0) {
            int reminder = x%10;
            sum = sum*10 + reminder;
            if (sum%10 != reminder) return 0;
            x = x/10;
        }

        return sum;
    }
}
