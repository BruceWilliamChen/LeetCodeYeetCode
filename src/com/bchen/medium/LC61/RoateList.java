package com.bchen.medium.LC61;

public class RoateList {
    public ListNode rotateRight(ListNode head, int k) {
        // use k to divide by length, find remainder
        // only need to know that because it is cycle
        if (head == null) return null;

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int remainder = k%length;

        // use 2 pointers fast and slow
        if (remainder == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        // use remainder to determine number of steps fast should go more
        for (int i = 0; i < remainder; i++) {
            fast = fast.next;
        }
        // then move both all the way to end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // now slow.next is the new head
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;

        return newHead;
    }
}
