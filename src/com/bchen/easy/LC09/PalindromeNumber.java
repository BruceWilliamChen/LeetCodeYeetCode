package com.bchen.easy.LC09;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //is negative, or can be evenly divided by 10, not palindrome
        if (x >= 0 && x < 10) return true;
        if (x < 0 || x%10 == 0) {
            return false;
        }

        int base = 0;
        while (x > base) {
            int remainder = x%10;
            base = base*10 + remainder;
            x = x/10;
        }

        //after that, either x < base or equal
        if (x == base || x == base/10) return true;

        return false;
    }
}
