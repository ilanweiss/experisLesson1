package com.exsperis;

public class Main {
/**
 Stack: 32 int
 Register file: 2 registers
 ax
 bx
 Instruction set:
 op
 0  push ax --> top stack
 1  pop ax <-- top stack
 2  mov ax, bx
 3  mov bx, ax
 4  load data ax <-- data
 5  add ax <- ax + bx
 6  sub ax <- ax - bx
 7  mul ax <- ax * bx
 8  div ax <- ax / bx
 9  jmp offset goto here + offset and continue from there
 10 jmz offset do the jump iff ax == 0
 11 print println(ax)

 starting state: stack is empty ax, bx are zeroed

 implement the virtual machine
 write small programs
 print all numbers from 1 to 32
 calculate 7!
 **/
    public static void main(String[] args) {
        System.out.println("Printing 1-32:");
        VM print1To32 = new VM(){};
        int[] programThatPrints1to32 = {4,1,2,4,32,0,6,0,10,3,9,-4,1,10,4,11,9,-4};
        print1To32.run(programThatPrints1to32);
        System.out.println("\n7 factorial equals:");
        VM sevenFactorial = new VM(){};
        int[] programThatPrints7factorial = {4,1,2,4,7,0,6,10,3,9,-4,4,1,2,1,10,6,7,2,9,-5,3,11};
        sevenFactorial.run(programThatPrints7factorial);
    }

}
