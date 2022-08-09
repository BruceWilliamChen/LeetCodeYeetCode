package com.bchen.medium.LC513;
import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        // level order traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return -1;

        queue.offer(root);

        boolean hasNextLevel = false;

        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            int leftMost = queue.peek().val;

            while (!queue.isEmpty()) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) nextLevel.offer(currNode.left);
                if (currNode.right != null) nextLevel.offer(currNode.right);
            }

            // if no next level, return left most
            if (nextLevel.size() == 0) return leftMost;

            // otherwise, take all stuff out and put it back in the queue
            while (!nextLevel.isEmpty()) {
                queue.offer(nextLevel.poll());
            }
        }

        return root.val;
    }
}
