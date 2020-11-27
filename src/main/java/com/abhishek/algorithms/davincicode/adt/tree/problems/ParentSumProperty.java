package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class ParentSumProperty {
    public static boolean isParentSum(TreeNode<? extends Number> node) {
        if (node == null)
            return true;
        Number left = (node.getLeft() == null) ? 0 : node.getLeft().getData();
        Number right = (node.getRight() == null) ? 0 : node.getRight().getData();
        boolean current=(left.doubleValue() + right.doubleValue() == node.getData().doubleValue())|| (left.doubleValue()==0 && right.doubleValue()==0);
        boolean leftSide=isParentSum(node.getLeft());
        boolean rightSide=isParentSum(node.getRight());
        return current && leftSide && rightSide;
    }
}
