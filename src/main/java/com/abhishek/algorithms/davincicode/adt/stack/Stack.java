package com.abhishek.algorithms.davincicode.adt.stack;

public class Stack<T> {

  private T stack[];
  private int size;
  private int top;
  private int capacity = 10;

  @SuppressWarnings("unchecked")
  public Stack() {
    this.stack = (T[]) new Object[this.capacity];
    this.size = 0;
    this.top = -1;
  }

  @SuppressWarnings("unchecked")
  public Stack(int capacity) {
    this.capacity = capacity;
    this.stack = (T[]) new Object[capacity];
    this.size = 0;
    this.top = -1;
  }

  public boolean push(T val) {
    if (top == this.capacity - 1) {
      throw new StackOverFlowException();
    }
    this.stack[++top] = val;
    this.size++;
    return true;
  }

  public boolean pop() {
    if (top == -1) {
      throw new StackUnderFlowException();
    }
    this.stack[top] = null;
    --top;
    return true;
  }

  public T top() {
    if (top == -1) {
      throw new StackUnderFlowException();
    }
    return this.stack[top];
  }

  public static void main(String args[]) {
    Stack<String> stack = new Stack<String>(5);
    stack.push("Abhishek");
    stack.push("Choudhury");
    System.out.println(stack.top());
  }

}
