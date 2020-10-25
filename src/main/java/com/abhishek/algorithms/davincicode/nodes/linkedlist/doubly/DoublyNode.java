package com.abhishek.algorithms.davincicode.nodes.linkedlist.doubly;

public class DoublyNode<T> {
  private T data;
  private DoublyNode<T> next;
  private DoublyNode<T> prev;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public DoublyNode<T> getNext() {
    return next;
  }

  public void setNext(DoublyNode<T> next) {
    this.next = next;
  }

  public DoublyNode<T> getPrev() {
    return prev;
  }

  public void setPrev(DoublyNode<T> prev) {
    this.prev = prev;
  }
}
