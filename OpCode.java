package com.exsperis;

public class OpCode{
    public static final int pushAxToStack = 0;
    public static final int popStackToAX = 1;
    public static final int moveAxToBx = 2;
    public static final int moveBxToAx = 3;
    public static final int loadDataToAx = 4;
    public static final int addBxToAx = 5;
    public static final int subBxFromAx = 6;
    public static final int multiplyBxWithAx = 7;
    public static final int divAxByBx = 8;
    public static final int jumpTo = 9;
    public static final int jumpIfAxIsZero = 10;
    public static final int printAx = 11;
    public static final int halt = 12;
    public static final int dup = 13;
    public static final int printChar = 14;
    public static final int jumpIfAxIsBelowZero = 15;
    public static final int jumpIfAxIsAboveZero = 16;
    public static final int skipIfAxIsNotZero = 17;
}

