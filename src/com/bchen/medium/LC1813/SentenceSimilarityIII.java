package com.bchen.medium.LC1813;

/*
- Longer string and shorter string
- Set up 2 pointers and  move at the same time from both ends of 2 strings towards the opposite direction
- Compare string from from same ends from 2 strings
- If equal, keep moving; If not, stop
- Check pointer on the shorter string, if upper end is smaller then lower end pointer, meaning, it has been fully walked

Exp1:
-> 1 2 3 4 5
-> 1 2 3

Exp2:
-> 1 2 3 4 5
->     3 4 5

Exp3:
-> 1 2 3 4 5
-> 1 2   4 5

 */

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1 == null || sentence2 == null) return true;

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int lower1 = 0, upper1 = words1.length - 1;
        int lower2 = 0, upper2 = words2.length - 1;

        // first move from lower on both senetences
        while (lower1 < words1.length && lower2 < words2.length) {
            if (words1[lower1].equals(words2[lower2])) {
                // equal then move both
                lower1++;
                lower2++;
            } else break;
        }

        while (upper1 >= 0 && upper2 >= 0) {
            if (words1[upper1].equals(words2[upper2])) {
                upper1--;
                upper2--;
            } else break;
        }

        // since we don't know which one is shorter, so check either pair of upper - lower < 0
        return (upper1 - lower1) < 0 || (upper2 - lower2 < 0);
    }
}

