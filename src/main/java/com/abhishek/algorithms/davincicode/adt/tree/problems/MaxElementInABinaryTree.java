package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class MaxElementInABinaryTree {
    public static Integer getMaxElement(TreeNode<Integer> node) {
        if (node == null)
            return null;
        Integer left = getMaxElement(node.getLeft());
        Integer right = getMaxElement(node.getRight());
        if (left == null && right == null)
            return node.getData();
        else if (left == null)
            return (right > node.getData()) ? node.getRight().getData() : node.getData();
        else if (right == null)
            return (left > node.getData()) ? node.getLeft().getData() : node.getData();
        else
            return Math.max(Math.max(left, right), node.getData());
    }
}
