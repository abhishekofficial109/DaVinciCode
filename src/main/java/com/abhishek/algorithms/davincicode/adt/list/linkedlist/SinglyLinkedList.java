package com.abhishek.algorithms.davincicode.adt.list.linkedlist;

import com.abhishek.algorithms.davincicode.container.Container;
import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements List<T> {
    private SinglyNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public SinglyLinkedList(T data) {
        this.head = new SinglyNode<T>(data);
        this.size = 0;
    }

    @Override
    public boolean add(T data) {
        return addLast(data);
    }

    @Override
    public boolean addAll(Container<? extends T> c) {
        if (c == null || c.isEmpty())
            return false;
        Iterator<T> itr = (Iterator<T>) c.iterator();
        while (itr.hasNext()) {
            add(itr.next());
        }
        return true;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Container<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Container<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] t) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean addFirst(T data) {
        SinglyNode<T> newSinglyNode = new SinglyNode<T>(data);
        newSinglyNode.setNext(this.head);
        this.head = newSinglyNode;
        this.size++;
        return true;
    }

    @Override
    public boolean addLast(T data) {
        SinglyNode<T> newSinglyNode = new SinglyNode<T>(data);
        SinglyNode<T> temp = this.head;
        if (temp == null) {
            this.head = newSinglyNode;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newSinglyNode);
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeFirst() {
        SinglyNode<T> deleted = this.head;
        if (deleted == null)
            return false;
        this.head = this.head.getNext();
        this.size--;
        return true;
    }

    @Override
    public boolean removeLast() {
        SinglyNode<T> deleted = this.head;
        if (deleted == null)
            return false;
        else if (this.size == 1) {
            this.size--;
            this.head = null;
            return true;
        }
        SinglyNode<T> temp = deleted;
        deleted = deleted.getNext();
        while (deleted != null) {
            temp = deleted;
            deleted = deleted.getNext();
        }
        temp.setNext(null);
        this.size--;
        return true;
    }

    @Override
    public boolean search(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T set(int index, T t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int endIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        SinglyNode<T> singlyNode = this.head;
        String str = "";
        while (singlyNode != null) {
            str += singlyNode.getData() + "->";
            singlyNode = singlyNode.getNext();
        }
        return str;
    }

    public SinglyNode<T> getHead() {
        return head;
    }

    public void setHead(SinglyNode<T> head) {
        this.head = head;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasNext() {
        return new Itr().hasNext();
    }

    @Override
    public T next() {
        return new Itr().next();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        // TODO Auto-generated method stub
        List.super.forEachRemaining(action);
    }

    private class Itr implements Iterator<T> {

        SinglyNode<T> head;
        SinglyNode<T> currentNode;

        public Itr() {
            this.head = SinglyLinkedList.this.head;
            this.currentNode = null;
            if (this.head != null) {
                this.currentNode = this.head;
            }
        }

        @Override
        public boolean hasNext() {
            if (this.currentNode != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            SinglyNode<T> node = this.currentNode;
            this.currentNode = this.currentNode.getNext();
            return node.getData();
        }

    }

}
