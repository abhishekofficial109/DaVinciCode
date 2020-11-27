package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

import java.util.*;

public class MaximumWidthOfATree<T> {
    public static <T> int getMaximumWidthOfABinaryTree(TreeNode<T> node) {
        if (node == null)
            return 0;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        int result = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            result = Math.max(n, result);
            for (int i = 0; i < n; i++) {
                TreeNode<T> temp = queue.poll();
                if (temp.getLeft() != null)
                    queue.offer(temp.getLeft());
                if (temp.getRight() != null)
                    queue.offer(temp.getRight());
            }
        }
        return result;
    }

    private static <T> Map<Integer, Integer> maxWidthAtEveryLevel(TreeNode<T> node, Map<Integer, Integer> map, int current_level) {
        if (node == null)
            return map;
        Map<Integer, Integer> left = maxWidthAtEveryLevel(node.getLeft(), map, current_level + 1);
        left.merge(current_level, 1, Integer::sum);
        return maxWidthAtEveryLevel(node.getRight(), map, current_level + 1);
    }
    public static <T> int maxWidthAtEveryLevel(TreeNode<T> node){
        Map<Integer, Integer> map= maxWidthAtEveryLevel(node,new HashMap<Integer,Integer>(),1);
        int result=Integer.MIN_VALUE;
        for(Integer i:map.values()){
            result=Math.max(i,result);
        }
        return result;
    }
}
