package com.bchen.medium.LC06;

public class ZigzagConversion {
    // point is to find the pattern
    public String convert(String s, int numRows) {
        //going down and back up over and over again

        //create an array of 4 string builders
        if (s == null || s.length() == 0) return null;

        if (numRows <= 1) return s;

        StringBuilder[] holder = new StringBuilder[numRows];
        for (int i = 0; i < holder.length; i++) {
            holder[i] = new StringBuilder();
        }

        int mover = 0;

        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            holder[mover].append(s.charAt(i));
            if (mover == numRows - 1) flag = -1;
            else if (mover == 0) flag = 1;
            mover += flag;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder elem: holder) {
            result.append(elem.toString());
        }

        return result.toString();
    }
}
