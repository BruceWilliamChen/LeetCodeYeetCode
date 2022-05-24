package com.bchen.medium.LC02;

public class AddTwoNumbersIterative {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyHead = new ListNode(-1);
        ListNode reference = dummyHead;

        int carryOver = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carryOver;

            int digit = sum%10;
            carryOver = sum/10;

            ListNode newNode = new ListNode(digit);
            reference.next = newNode;
            reference = reference.next;
        }

        if (carryOver != 0) reference.next = new ListNode(carryOver);

        return dummyHead.next;
    }
}
