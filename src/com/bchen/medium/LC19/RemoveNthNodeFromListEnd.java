package com.bchen.medium.LC19;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //typical 2 pointer solution, one runs n steps faster
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //after this, slow's next will be the one that shoudl be removed
        slow.next = slow.next.next;

        return head;
    }
}
