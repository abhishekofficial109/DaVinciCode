package com.abhishek.algorithms.davincicode.adt.list;

import java.util.Stack;

import com.abhishek.algorithms.davincicode.adt.list.linkedlist.SinglyLinkedList;
import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

/*
 * Reverse a singly linked list
 */
public class ReverseALinkedList {

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    list.add(5);
    list.add(10);
    list.add(15);
    list.add(20);
    list.add(25);
    list.add(30);
    list.setHead(reverse(list.getHead()));
    System.out.println(list);
    list.setHead(reverseIterative(list.getHead()));
    System.out.println(list);
    list.setHead(reverse2(list.getHead(), null));
    System.out.println(list);
  }

  public static <T> SinglyNode<T> reverse(SinglyNode<T> node) {
    if (node.getNext() == null)
      return node;
    SinglyNode<T> next = reverse(node.getNext());
    SinglyNode<T> temp = node.getNext();
    node.setNext(temp.getNext());
    temp.setNext(node);
    return next;
  }

  public static <T> SinglyNode<T> reverse2(SinglyNode<T> n, SinglyNode<T> prev) {
    if (n == null)
      return prev;
    SinglyNode<T> p = n.getNext();
    n.setNext(prev);
    SinglyNode<T> t = p.getNext();
    prev = p;
    prev.setNext(n);
    return reverse2(t, prev);
  }

  public static <T> SinglyNode<T> reverseIterative(SinglyNode<T> n) {
    SinglyNode<T> temp = n, prev = null;
    while (temp != null) {
      SinglyNode<T> t = temp.getNext();
      temp.setNext(prev);
      SinglyNode<T> p = t.getNext();
      t.setNext(temp);
      prev = t;
      temp = p;
    }
    return prev;
  }

}
