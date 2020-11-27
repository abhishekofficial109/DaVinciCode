package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class SizeOfABinaryTree<T> {
    public static <T> int getSize(TreeNode<T> node){
        if(node==null)
            return 0;
        return 1+getSize(node.getLeft())+getSize(node.getRight());
    }
}
