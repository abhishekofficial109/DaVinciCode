package com.abhishek.algorithms.davincicode.adt.stack;

public class StackOverFlowException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String ERROR = "Stack size is full";

    public StackOverFlowException() {
        super(ERROR);
    }

    @Override
    public String toString() {
        return ERROR;
    }

}
