package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
    private static <T> boolean isBalanced(TreeNode<T> node,Map<TreeNode<T>, Integer> map){
        if(node==null)
            return true;
        boolean left=isBalanced(node.getLeft(),map);
        boolean right=isBalanced(node.getRight(),map);
        return (Math.abs((map.get(node.getRight())==null)?0:map.get(node.getRight()) - (map.get(node.getLeft())==null?0:map.get(node.getLeft())))) <= 1;
    }
    private static <T> Map<TreeNode<T>,Integer> populateHeights(TreeNode<T> node,Map<TreeNode<T>, Integer> map){
        if(node==null)
            return map;
        Map<TreeNode<T>,Integer> left=populateHeights(node.getLeft(),map);
        Map<TreeNode<T>,Integer> right=populateHeights(node.getRight(),map);
        int current_height=(node.getLeft()==null)?0:map.get(node.getLeft())+((node.getRight()==null)?0:map.get(node.getRight()))+1;
        map.put(node,current_height);
        return map;
    }
    public static <T> boolean isBalanced(TreeNode<T> node){
        Map<TreeNode<T>,Integer> map=new HashMap<>();
        return isBalanced(node,map);
    }
}
