package com.abhishek.algorithms.davincicode.adt.stack;

public class StackUnderFlowException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Stack is already empty";

    public StackUnderFlowException() {
        super(ERROR_MESSAGE);
    }

}
