package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

public class PrintNodeAtDistanceK {

    public static <T> void printNodesAtDistanceK(TreeNode<T> node,int k){
        printNodesAtDistanceKHlpr(node,k);
    }
    private static <T> void printNodesAtDistanceKHlpr(TreeNode<T> node,int k){
        if(node==null)
            return;
        else if(k==0) {
            System.out.print(node.getData()+",");
            return;
        }
        printNodesAtDistanceKHlpr(node.getLeft(),k-1);
        printNodesAtDistanceKHlpr(node.getRight(),k-1);
    }
}
