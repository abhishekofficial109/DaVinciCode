package com.abhishek.algorithms.davincicode.adt.list;

import java.util.HashSet;
import java.util.Set;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class LoopDetection {

  public static void main(String[] args) {

  }

  // Naive approach
  public static <T> boolean isLoop1(SinglyNode<T> head) {
    if (head == null)
      return false;
    SinglyNode<T> temp = head.getNext();
    while (temp != null) {
      SinglyNode<T> aux = head;
      while (aux != temp) {
        if (aux == temp.getNext())
          return true;
        aux = aux.getNext();
      }
      temp = temp.getNext();
    }
    return false;
  }

  // Dummy node method
  public static <T> boolean isLoop2(SinglyNode<T> head) {
    if (head == null)
      return false;
    SinglyNode<T> temp = head;
    SinglyNode<T> dummy = head;
    SinglyNode<T> prev = null;
    while (temp != null) {
      if (temp.getNext() != null && temp.getNext().getNext() == dummy)
        return true;
      prev.setNext(dummy);
      prev = temp;
      temp = temp.getNext();

    }
    return false;
  }

  // Using Set
  public static <T> boolean isLoop3(SinglyNode<T> head) {
    Set<SinglyNode<T>> set = new HashSet<>();
    if (head == null)
      return false;
    SinglyNode<T> temp = head;
    while (temp != null) {
      if (set.contains(temp))
        return true;
      set.add(temp);
      temp = temp.getNext();
    }
    return false;
  }

  // Using floyd detection cycle
  public static <T> boolean isLoop4(SinglyNode<T> head) {
    SinglyNode<T> slow = head;
    SinglyNode<T> fast = slow;
    if (slow == null)
      return false;
    while (fast != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast)
        return true;
    }
    return false;
  }
}
