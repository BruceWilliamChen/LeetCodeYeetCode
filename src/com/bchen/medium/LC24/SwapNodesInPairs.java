package com.bchen.medium.LC24;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextNode = head.next;
        head.next = this.swapPairs(nextNode.next);
        nextNode.next = head;

        return nextNode;
    }
}
