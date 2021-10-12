package com.exsperis;

import static com.exsperis.OpCode.*;

public class SampleProgram{

    public int[] programThatPrints1to32 = {
            loadDataToAx,1, moveAxToBx,loadDataToAx,32, pushAxToStack,
            subBxFromAx,pushAxToStack, jumpIfAxIsZero,3, jumpTo,-4,
            popStackToAX, jumpIfAxIsZero,4, printAx,jumpTo,-4};

    public int[] programThatPrints7factorial = {
            loadDataToAx, 1, moveAxToBx, loadDataToAx, 7, pushAxToStack,
            subBxFromAx, jumpIfAxIsZero, 3,jumpTo, -4, loadDataToAx, 1,
            moveAxToBx, popStackToAX, jumpIfAxIsZero, 6, multiplyBxWithAx,
            moveAxToBx, jumpTo, -5, moveBxToAx, printAx};

    public int[] upperABC = {loadDataToAx, 1, moveAxToBx, loadDataToAx, 26,
            pushAxToStack, subBxFromAx, jumpIfAxIsZero, 3,jumpTo, -4,
            loadDataToAx, 64, moveAxToBx, popStackToAX, jumpIfAxIsZero, 6,
            addBxToAx, printChar, jumpTo, -5};

    public int[] lowerABC = {loadDataToAx, 1, moveAxToBx, loadDataToAx, 26,
            pushAxToStack, subBxFromAx, jumpIfAxIsZero, 3,jumpTo, -4,
            loadDataToAx, 96, moveAxToBx, popStackToAX, jumpIfAxIsZero, 6,
            addBxToAx, printChar, jumpTo, -5};


    public SampleProgram() {
    }
}
