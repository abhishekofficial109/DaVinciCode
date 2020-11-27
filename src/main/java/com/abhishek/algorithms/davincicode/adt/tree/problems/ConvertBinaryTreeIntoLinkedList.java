package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class ConvertBinaryTreeIntoLinkedList<T> {
//    public static <T> TreeNode<T> buildLinkedListFromABinaryTree(TreeNode<T> node){
//        if(node==null)
//            return null;
//        TreeNode<T> left=buildLinkedListFromABinaryTree(node.getLeft());
//        TreeNode<T> right=buildLinkedListFromABinaryTree(node.getRight());
//        if(left==null){
//            node.setLeft(null);
//            node.setRight(right);
//            return node;
//        }
//        else{
//            if(left.getRight()!=null) {
//                left.getRight().setRight(node);
//                node.setLeft(left.getRight().getRight());
//            }
//            else {
//                left.setRight(node);
//            }
//            node.setLeft(left);
//        }
//    }
}
