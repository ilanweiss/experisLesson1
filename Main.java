package com.exsperis;

import static com.exsperis.OpCode.*;

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

        VM vm = new VM(){};
        SampleProgram sp = new SampleProgram();

        System.out.println("Printing 1-32:");
        vm.run(sp.programThatPrints1to32);

        System.out.println("\n7 factorial equals:");
        vm.run(sp.programThatPrints7factorial);

        System.out.println("\nA-Z:");
        vm.run(sp.upperABC);

        System.out.println("\na-z:");
        vm.run(sp.lowerABC);
    }

}
