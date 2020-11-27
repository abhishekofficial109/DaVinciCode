package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class PrintLeftViewOfABinaryTree {
    public static <T> void printLeftView(TreeNode<T> node) {
        System.out.println();
        if (node == null)
            return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        LinkedList<TreeNode<T>> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode<T> item = queue.poll();
                if (item.getLeft() != null)
                    queue.offer(item.getLeft());
                if (item.getRight() != null)
                    queue.offer(item.getRight());
                list.add(item);
            }
            list.add(null);
        }
        System.out.print(list.get(0).getData()+",");
        for(int i=2;i<list.size()-1;i++){
            if(list.get(i-1)==null){
                System.out.print(list.get(i).getData()+",");
            }
        }
    }
}
