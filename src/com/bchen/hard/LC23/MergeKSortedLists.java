package com.bchen.hard.LC23;

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //use priority queue to always find the smallest among k nodes
        if (lists == null || lists.length == 0) {
            return null;
        }


        ListNode fakeHead = new ListNode(0);
        ListNode pointer = fakeHead;

        Queue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val; //min-heap
            }
        });

        for (ListNode node: lists) {
            if (node != null) {
                //if still not null, then put it's head into the queue
                pq.offer(node);
            }
        }

        //then start to poll and offer, just like BFS on tree
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            pointer.next = new ListNode(minNode.val);
            //then advance the pointer, and offer new nodes, which is the next node of the one that was polled out
            pointer = pointer.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        //eventually, return the next of the fakeHead, which is the actual start
        return fakeHead.next;
    }
}
