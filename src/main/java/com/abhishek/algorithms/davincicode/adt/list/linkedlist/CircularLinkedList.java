package com.abhishek.algorithms.davincicode.adt.list.linkedlist;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class CircularLinkedList<T> {

    private SinglyNode<T> tail;
    private int size;

    public T add(T data) {
        if (tail == null) {
            this.tail = new SinglyNode<T>(data);
            this.size++;
            return data;
        }
        SinglyNode<T> newNode = new SinglyNode<T>(data);
        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        tail = newNode;
        return data;
    }

    @Override
    public String toString() {
        String s = "";
        if (tail == null)
            return s + "[";
        String aux = "";
        SinglyNode<T> temp = this.tail.getNext();
        while (temp != null && temp != tail) {
            aux += temp.getData() + ",";
            temp = temp.getNext();
        }
        aux += tail.getData() + "]";
        return aux;
    }

}
