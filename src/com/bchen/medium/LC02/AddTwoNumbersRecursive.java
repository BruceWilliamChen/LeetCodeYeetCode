package com.bchen.medium.LC02;

public class AddTwoNumbersRecursive {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        return recursiveAddition(l1, l2, 0);
    }

    public ListNode recursiveAddition(ListNode node1, ListNode node2, int carryOver) {
        if (node1 == null && node2 == null && carryOver == 0) return null;

        int sum = 0;

        if (node1 != null) {
            sum += node1.val;
            node1 = node1.next;
        }
        if (node2 != null) {
            sum += node2.val;
            node2 = node2.next;
        }

        sum += carryOver;

        int currentDigit = sum%10;
        carryOver = sum/10;
        ListNode newNode = new ListNode(currentDigit);
        newNode.next = recursiveAddition(node1, node2, carryOver);

        return newNode;
    }
}
