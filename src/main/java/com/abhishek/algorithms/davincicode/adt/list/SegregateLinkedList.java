package com.abhishek.algorithms.davincicode.adt.list;

import com.abhishek.algorithms.davincicode.adt.list.linkedlist.SinglyLinkedList;
import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class SegregateLinkedList {

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    System.out.println(list);
    list.setHead(segregateLinkedList(list.getHead()));
    System.out.println(list);

  }

  // Based on index
  public static <T> SinglyNode<T> segregateLinkedList(SinglyNode<T> node) {
    if (node == null)
      return null;
    SinglyNode<T> output = null, temp = node;
    SinglyNode<T> even = null, even_head = null, odd = null, odd_head = null;
    int count = 1;
    while (temp != null) {
      if (count % 2 == 0) {
        if (even_head == null) {
          even_head = temp;
          even = even_head;
        } else {
          even.setNext(temp);
          even = even.getNext();
        }
      } else {
        if (odd_head == null) {
          odd_head = temp;
          odd = odd_head;
        } else {
          odd.setNext(temp);
          odd = odd.getNext();
        }
      }
      temp = temp.getNext();
      count++;
    }
    odd.setNext(null);
    even.setNext(odd_head);
    return even_head;
  }
}
