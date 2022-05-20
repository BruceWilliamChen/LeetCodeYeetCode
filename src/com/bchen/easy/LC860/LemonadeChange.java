package com.bchen.easy.LC860;


// count the number of each bills as move along
// consume bill as move along

// note always first use big bill as much as possible and then smaller for change

// whenever any needed bill is 0 return false


public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0, num10 = 0, num20 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                // no change
                num5++;
            }
            if (bills[i] == 10) {
                if (num5 <= 0) return false;
                num5--;
                num10++;
            }
            if (bills[i] == 20) {
                // if no 10, then have to be at least three 5
                if (num10 <= 0 && num5 < 3) return false;
                // if at least one 10, but no 5
                if (num10 > 0 && num5 <= 0) return false;

                // then change based on if there is 10
                if (num10 > 0) {
                    num10--;
                    num5--;
                } else {
                    num5 -= 3;
                }
            }
        }

        return true;
    }
}
