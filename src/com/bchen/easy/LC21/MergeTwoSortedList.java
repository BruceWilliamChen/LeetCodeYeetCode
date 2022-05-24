package com.bchen.easy.LC21;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //could do this recursively
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode curr1 = l1, curr2 = l2;

        if (curr1.val >= curr2.val) {
            curr2.next = mergeTwoLists(curr1, curr2.next);
            return curr2;
        }
        curr1.next = mergeTwoLists(curr1.next, curr2);
        return curr1;

    }
}
