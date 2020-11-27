package com.abhishek.algorithms.davincicode.adt.tree.binarysearchtree;

import com.abhishek.algorithms.davincicode.adt.tree.problems.*;
import com.abhishek.algorithms.davincicode.nodes.tree.TreeNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T data) {
        this.root = new TreeNode<T>(data);
        this.size++;
    }

    private TreeNode<T> add(T data, TreeNode<T> node) {
        if (node == null) {
            return new TreeNode<T>(data);
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        if (leftHeight <= rightHeight) {
            TreeNode<T> newNode = add(data, node.getLeft());
            node.setLeft(newNode);
        } else {
            TreeNode<T> newNode = add(data, node.getRight());
            node.setRight(newNode);
        }
        return node;
    }

    public void addBalanced(T data){
        this.root=add(data,this.root);
    }


    public boolean add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (this.root == null) {
            this.root = newNode;
            this.size++;
            return true;
        } else {
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(this.root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode<T> node = queue.poll();
                    if (node == null)
                        return false;
                    else if (node.getData().equals(data)) {
                        return false;
                    } else if (node.getLeft() == null) {
                        node.setLeft(newNode);
                        this.size++;
                        return true;
                    } else if (node.getRight() == null) {
                        node.setRight(newNode);
                        this.size++;
                        return true;
                    } else if (node.getLeft() != null)
                        queue.offer(node.getLeft());
                    else if (node.getRight() != null)
                        queue.offer(node.getRight());
                }
            }
            return false;
        }
    }

    public int getHeight(TreeNode<T> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public Set<T> inOrder() {
        Set<T> set = new LinkedHashSet<>();
        return inOrder(set, this.root);
    }

    private Set<T> inOrder(Set<T> set, TreeNode<T> node) {
        if (node == null)
            return set;
        Set<T> left = inOrder(set, node.getLeft());
        left.add(node.getData());
        return inOrder(set, node.getRight());
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public static void main(String args[]) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addBalanced(40);
        tree.addBalanced(10);
        tree.addBalanced(90);
        tree.addBalanced(50);
        tree.addBalanced(30);
        tree.addBalanced(100);
        tree.addBalanced(110);
        Set<Integer> set = tree.inOrder();
        System.out.println(set);
        LevelOrderLineByLine.printLineByLine(tree.getRoot());
        System.out.println("Size of a binary tree: "+ SizeOfABinaryTree.getSize(tree.getRoot()));
        System.out.println("Maximum element in a tree: "+ MaxElementInABinaryTree.getMaxElement(tree.getRoot()));
        PrintNodeAtDistanceK.printNodesAtDistanceK(tree.getRoot(),2);
        PrintLeftViewOfABinaryTree.printLeftView(tree.getRoot());
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        tree1.addBalanced(40);
        tree1.addBalanced(30);
        tree1.addBalanced(10);
        System.out.println();
        System.out.println("Is Parent sum property: "+ParentSumProperty.isParentSum(tree.getRoot()));
        System.out.println("Is Parent sum property: "+ParentSumProperty.isParentSum(tree1.getRoot()));
        System.out.println("Is Balanced binary tree:"+BalancedBinaryTree.isBalanced(tree.getRoot()));
        System.out.println("Maximum width at any level:"+MaximumWidthOfATree.getMaximumWidthOfABinaryTree(tree.getRoot()));
        System.out.println("Maximum width at any level:"+MaximumWidthOfATree.maxWidthAtEveryLevel(tree.getRoot()));
        System.out.println("Diameter of a binary tree: "+DiameterOfABinaryTree.getDiameterOfABinaryTree(tree.getRoot()));
    }
}
