package com.abhishek.algorithms.davincicode.adt.stack.problems;

import java.util.Arrays;

import com.abhishek.algorithms.davincicode.adt.stack.StackOverFlowException;
import com.abhishek.algorithms.davincicode.adt.stack.StackUnderFlowException;

public class KStackImplementation<T> {

  private T[] stack;
  private int[] top;
  private int[] next;
  private int k = 2, free = 0, capacity = 10;

  @SuppressWarnings("unchecked")
  public KStackImplementation() {
    super();
    this.stack = (T[]) new Object[capacity];
    this.top = new int[k];
    this.next = new int[capacity];
    Arrays.fill(top, -1);
    for (int i = 0; i < capacity - 1; i++)
      next[i] = i + 1;
    next[capacity - 1] = -1;
  }

  @SuppressWarnings("unchecked")
  private KStackImplementation(int k, int capacity) {
    this.capacity = capacity;
    this.k = k;
    this.stack = (T[]) new Object[capacity];
    this.top = new int[k];
    this.next = new int[capacity];
    Arrays.fill(top, -1);
    for (int i = 0; i < capacity - 1; i++)
      next[i] = i + 1;
    next[capacity - 1] = -1;
  }

  boolean isFull() {
    return (free == -1);
  }

  void push(T item, int sn) {
    if (isFull()) {
      throw new StackOverFlowException();
    }
    int i = free;
    free = next[i];
    next[i] = top[sn];
    top[sn] = i;
    stack[i] = item;
  }

  T pop(int sn) {
    if (isEmpty(sn)) {
      throw new StackUnderFlowException();
    }
    int i = top[sn];
    top[sn] = next[i];
    next[i] = free;
    free = i;
    return stack[i];
  }

  boolean isEmpty(int sn) {
    return (top[sn] == -1);
  }

  public static void main(String[] args) {
    int k = 3, n = 10;

    KStackImplementation<Integer> ks = new KStackImplementation<Integer>(k, n);

    ks.push(15, 2);
    ks.push(45, 2);

    // Let us put some items in stack number 1
    ks.push(17, 1);
    ks.push(49, 1);
    ks.push(39, 1);

    // Let us put some items in stack number 0
    ks.push(11, 0);
    // ks.push(9, 0);
    // ks.push(7, 0);
    // ks.push(9, 0);
    // ks.push(7, 0);
    // ks.push(9, 0);
    // ks.push(7, 0);

    System.out.println("Popped element from stack 2 is " + ks.pop(2));
    System.out.println("Popped element from stack 1 is " + ks.pop(1));
    System.out.println("Popped element from stack 0 is " + ks.pop(0));
  }

}
