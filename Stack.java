package com.exsperis;

public class Stack {
    private int[] stack;
    private int topOfStack;
    private static final int capacity = 32;

    public Stack(){
        this.stack = new int[capacity];
        this.topOfStack = -1;
    }

    public boolean isEmpty(){
        return (topOfStack < 0);
    }

    public boolean isFull(){
        return (topOfStack>=capacity-1);
    }

    public void push(int numberToPush){
        if (isFull()){
            System.out.println("Stack is Full, can't push");
        }else{
            stack[++topOfStack]= numberToPush;
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is Empty, can't pop");
            return -1;
        }else{
            return stack[topOfStack--];
        }
    }
}
