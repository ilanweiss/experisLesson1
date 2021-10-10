package com.exsperis;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class VM{
    private static int[] stack;
    private static int stackIndex;
    private static int[] register;
    private static boolean stackIsFull;
    private static boolean stackOverflow;

    public VM(){
        this.stack = new int[32];
        this.stackIndex = 31;
        this.register = new int[2];
        this.stackIsFull = false;
        this.stackOverflow = false;
    }


    public static void run(int[] prog){

        for (int i = 0; i < prog.length; i++) {
            int opcode = prog[i];
            switch (opcode) {
                case 0:
                    pushVal();
                    break;
                case 1:
                    popVal();
                    break;
                case 2:
                    moveAxToBx();
                    break;
                case 3:
                    moveBxToAx();
                    break;
                case 4:
                    loadToAX(prog[++i]);
                    break;
                case 5:
                    addAxToBx();
                    break;
                case 6:
                    subBxFromAx();
                    break;
                case 7:
                    multAxWithBx();
                    break;
                case 8:
                    divAxByBx();
                    break;
                case 9:
                    i=i+prog[i+1]-1;
                    break;
                case 10:
                    if (register[0] == 0){
                        i = i+prog[i+1]-1;
                    }else{
                        i++;
                    }
                    break;
                case 11:
                    printAx(register[0]);
                    break;
            }
        }
    }

    private static void moveVal(int value, int index,int[] arrayToMoveTo){
        arrayToMoveTo[index]= value;
    }

    private static void pushVal(){
        if (!stackIsFull) {
            moveVal(register[0], stackIndex, stack);
            stackIndex--;
            if (stackIndex<0){
                stackIsFull=true;
            }
        }else {
            register[0]=0;
        }
    }

    private static void popVal(){
        if (!stackOverflow){
            moveVal(stack[++stackIndex], 0, register);
            if (stackIndex>30){
                stackOverflow=true;
            }
        }else{
            register[0]=0;
        }
    }

    private static void moveAxToBx() {
        moveVal(register[0],1,register);
    }

    private static void moveBxToAx() {
        moveVal(register[1],0,register);
    }

    private static void loadToAX(int value){
        moveVal(value,0,register);
    }

    private static void addAxToBx() {
        moveVal(register[0]+register[1],0,register);
    }

    private static void subBxFromAx() {
        moveVal(register[0]-register[1],0,register);
    }

    private static void multAxWithBx() {
        moveVal(register[0]*register[1],0,register);
    }

    private static void divAxByBx() {
        moveVal(register[0]/register[1],0,register);
    }

    private static void printAx(int ax){
        System.out.print(ax + " ");
    }
}
