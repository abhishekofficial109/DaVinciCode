package com.abhishek.algorithms.davincicode.adt.list;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class FindStartOfALoop {

  public static void main(String[] args) {

  }

  public static <T> T getTheStartOfALoop(SinglyNode<T> head) {
    if (head == null)
      return null;
    SinglyNode<T> slow = head;
    SinglyNode<T> fast = slow;
    while (fast != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast)
        break;
    }
    if (slow != fast)
      return null;
    slow = head;
    while (slow.getNext().getData() != fast.getNext().getData()) {
      slow = slow.getNext();
      fast = fast.getNext();
    }
    return slow.getNext().getData();
  }

}
