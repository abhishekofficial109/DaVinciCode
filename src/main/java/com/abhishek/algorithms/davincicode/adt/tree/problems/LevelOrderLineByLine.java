package com.abhishek.algorithms.davincicode.adt.tree.problems;

import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine<T> {
    public static <T>  void printLineByLine(TreeNode<T> node){
        if(node==null)
            return;
        Queue<TreeNode<T>> queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode<T> temp=queue.poll();
                if(temp.getLeft()!=null)
                    queue.offer(temp.getLeft());
                if(temp.getRight()!=null)
                    queue.offer(temp.getRight());
                System.out.print(temp.getData()+",");
            }
            System.out.println();
        }
    }
}
