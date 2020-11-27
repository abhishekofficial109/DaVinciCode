package com.abhishek.algorithms.davincicode.adt.stack.problems;

import com.abhishek.algorithms.davincicode.adt.stack.StackUnderFlowException;

public class ImplementTwoStacksInOneArray<T> {
    private T stack[];
    private int size1;
    private int size2;
    private int top1;
    private int top2;
    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public ImplementTwoStacksInOneArray(int capacity) {
        super();
        this.capacity = capacity;
        this.stack = (T[]) new Object[this.capacity];
        this.top1 = -1;
        this.top2 = this.capacity;
        this.size1 = 0;
    }

    @SuppressWarnings("unchecked")
    public ImplementTwoStacksInOneArray() {
        super();
        this.stack = (T[]) new Object[this.capacity];
        this.top1 = -1;
        this.top2 = this.capacity;
        this.size2 = 0;
    }

    public void push(T data, int container_index) {
        if (container_index == 1) {
            if (top1 + 1 == top2)
                throw new StackOverflowError();
            this.stack[++top1] = data;
            this.size1++;
        } else {
            if (top2 - 1 == top2)
                throw new StackOverflowError();
            this.stack[--top2] = data;
            this.size2++;
        }
    }

    public T pop(int container_index) {
        if (container_index == 1) {
            if (top1 == -1)
                throw new StackUnderFlowException();
            T deletedObj = this.stack[top1];
            this.stack[top1] = null;
            this.top1--;
            this.size1--;
            return deletedObj;
        } else {
            if (top2 == capacity)
                throw new StackUnderFlowException();
            T deletedObj = this.stack[top2];
            this.stack[top2] = null;
            this.top2--;
            this.size2--;
            return deletedObj;
        }
    }

}
