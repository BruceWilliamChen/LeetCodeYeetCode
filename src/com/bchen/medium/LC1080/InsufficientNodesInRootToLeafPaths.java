package com.bchen.medium.LC1080;

public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        //deleting a node deletes all its children
        return this.isInsufficient(root, 0, limit)? null : root;
    }

    public boolean isInsufficient(TreeNode currNode, int pathSum, int limit) {
        if (currNode == null) return true;
        if (currNode.left == null && currNode.right == null) {
            //when leaf
            if (currNode.val + pathSum < limit) {
                //if smaller, then return true
                return true;
            }
            return false; //otherwise false
        }
        // if not leaf then DFS first then check
        pathSum = pathSum + currNode.val;
        boolean isLeftInsufficient = this.isInsufficient(currNode.left, pathSum, limit);
        boolean isRightInsufficient = this.isInsufficient(currNode.right, pathSum, limit);
        // check again for both ends
        if (isLeftInsufficient && isRightInsufficient) {
            currNode.left = null;
            currNode.right = null;
            return true;
        }
        if (isLeftInsufficient) currNode.left = null;
        if (isRightInsufficient) currNode.right = null;
        return false;
    }
}
