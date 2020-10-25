package com.abhishek.algorithms.davincicode.adt.list.linkedlist;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.doubly.DoublyNode;

/**
 * @author abhishek
 *
 * @param <T>
 */

public class DoublyLinkedList<T> {
  private DoublyNode<T> head;
  private DoublyNode<T> tail;
  private int size;

  public DoublyLinkedList() {
    super();
  }

  public DoublyNode<T> getHead() {
    return head;
  }

  public DoublyNode<T> getTail() {
    return tail;
  }

  public int size() {
    return size;
  }

  public T addToStart(T data) {
    if (this.head == null) {
      DoublyNode<T> newNode = new DoublyNode<T>();
      newNode.setData(data);
      newNode.setNext(null);
      newNode.setPrev(null);
      this.head = newNode;
      this.tail = newNode;
      this.size++;
      return newNode.getData();
    } else {
      DoublyNode<T> newNode = new DoublyNode<T>();
      newNode.setData(data);
      newNode.setNext(this.head);
      newNode.setPrev(null);
      this.head = newNode;
      this.size++;
      return newNode.getData();
    }
  }

  public T addToEnd(T data) {
    if (this.head == null) {
      DoublyNode<T> newNode = new DoublyNode<T>();
      newNode.setData(data);
      newNode.setNext(null);
      newNode.setPrev(null);
      this.head = newNode;
      this.tail = newNode;
      this.size++;
      return newNode.getData();
    } else {
      DoublyNode<T> newNode = new DoublyNode<T>();
      newNode.setData(data);
      newNode.setNext(null);
      newNode.setPrev(this.tail);
      this.tail = newNode;
      this.size++;
      return newNode.getData();
    }
  }

  @Override
  public String toString() {
    String s = "";
    if (this.head == null)
      return null;
    DoublyNode<T> temp = this.head;
    while (temp != null) {
      s += temp.getData() + " , ";
      temp = temp.getNext();
    }
    return s;
  }

}
