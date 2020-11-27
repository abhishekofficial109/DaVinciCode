package com.abhishek.algorithms.davincicode.adt.list;

import com.abhishek.algorithms.davincicode.adt.list.linkedlist.SinglyLinkedList;
import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class MiddleOfALinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        System.out.println("Middle of a list: " + getMiddleNaive(list));
        System.out.println("Middle of a list: " + getMiddleEfficient(list));
    }

    /*
     * Time complexity: O(n)
     *
     *
     */
    public static <T> Object getMiddleNaive(SinglyLinkedList<? extends T> list) {
        // get the size of the linkedlist
        int size = list.size();
        if (size == 0)
            return null;
        SinglyNode<? extends T> node = list.getHead();
        int count = 1;
        while (count < size / 2) {
            node = node.getNext();
            count++;
        }
        return node.getNext().getData();
    }

    public static <T> Object getMiddleEfficient(SinglyLinkedList<? extends T> list) {
        SinglyNode<? extends T> node = list.getHead();
        if (node == null)
            return null;
        SinglyNode<? extends T> slow = node;
        SinglyNode<? extends T> fast = node;
        while (fast != null) {
            if (fast.getNext() == null)
                return slow.getData();
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow.getData();
    }
}
