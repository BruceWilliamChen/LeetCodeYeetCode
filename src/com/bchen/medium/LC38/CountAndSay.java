package com.bchen.medium.LC38;

public class CountAndSay {
    public String countAndSay(int n) {
        // n term determined by n - 1 term, so let's do this recursively
        if (n == 0) return "";
        if (n == 1) return "1";

        String lastCountAndSay = countAndSay(n-1);
        // now use this info to calculate current say string
        StringBuilder currCountAndSay = new StringBuilder();

        int index = 0;

        while(index < lastCountAndSay.length()) {
            int counter = 0;
            char anchor = lastCountAndSay.charAt(index);
            while (index < lastCountAndSay.length() && lastCountAndSay.charAt(index) == anchor) {
                index++;
                counter++;
            }
            // whenever stopped, put count and say in result
            currCountAndSay.append(counter);
            currCountAndSay.append(anchor);
        }

        return currCountAndSay.toString();
    }
}
