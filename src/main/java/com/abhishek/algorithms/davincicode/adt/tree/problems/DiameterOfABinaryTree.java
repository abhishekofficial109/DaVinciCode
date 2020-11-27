package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class DiameterOfABinaryTree<T> {
    public static <T> int getDiameterOfABinaryTree(TreeNode<T> node){
        if(node==null)
            return 0;
        int leftSubtree=getDiameterOfABinaryTree(node.getLeft());
        int rightSubtree=getDiameterOfABinaryTree(node.getRight());
        int totalHeight=height(node.getRight())+height(node.getLeft())+1;
        return Math.max(totalHeight,Math.max(leftSubtree,rightSubtree));
    }
    private static <T> int height(TreeNode<T> node){
        if(node==null)
            return 0;
        return Math.max(height(node.getLeft()),height(node.getRight()))+1;
    }
}
