package com.bchen.medium.LC50;

public class Pow {
    public double myPow(double x, int n) {
        // use fast power method, meaning, x^n = (x^2)^(n/2) so that time complexity is LogN
        // do this recursively
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (n == 2) return x*x;
        if (n == -2) return 1/(x*x);

        double temp = myPow(x, n/2);
        return n%2 == 0? temp*temp : n < 0? temp*temp*(1/x) : temp*temp*x;
    }
}
