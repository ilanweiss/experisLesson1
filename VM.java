package com.exsperis;

import static com.exsperis.OpCode.*;

public class VM{
    private final Stack stack;
    private final Register register;
    private final Alu alu;
    private Controller controller;

    public VM(){
        this.stack = new Stack();
        this.register = new Register();
        this.alu = new Alu(register);
        this.controller = new Controller();
    }

    public void run(int[] prog){

        controller = new Controller(prog.length);
        while(controller.hasNext()) {
            int opcode = prog[controller.getCurrentInstruction()];
            try {
                dispatch(prog, opcode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            controller.nextInstruction();
        }
    }

    private void dispatch(int[] prog, int opcode) {
        switch (opcode) {
            case pushAxToStack:
                pushVal();
                break;
            case popStackToAX:
                popVal();
                break;
            case dup:
                stack.dup();
                break;
            case moveAxToBx:
                register.moveAxToBx();
                break;
            case moveBxToAx:
                register.moveBxToAx();
                break;
            case loadDataToAx:
                register.loadAx(prog[controller.getNextInstruction()]);
                controller.nextInstruction();
                break;
            case addBxToAx:
                alu.addAxToBx();
                break;
            case subBxFromAx:
                alu.subBxFromAx();
                break;
            case multiplyBxWithAx:
                alu.multiplyAxWithBx();
                break;
            case divAxByBx:
                alu.divAxByBx();
                break;
            case halt:
                controller.haltInstruction();
                break;
            case jumpTo:
                controller.jumpTo(prog[controller.getNextInstruction()]);
                break;
            case jumpIfAxIsZero:
                if (register.AxIsZero()){
                    controller.jumpTo(prog[controller.getNextInstruction()]);
                }else{
                    controller.nextInstruction();
                }
                break;
            case jumpIfAxIsBelowZero:
                if (register.getAx()<0){
                    controller.jumpTo(prog[controller.getNextInstruction()]);
                }else{
                    controller.nextInstruction();
                }
                break;
            case jumpIfAxIsAboveZero:
                if (register.getAx()>0){
                    controller.jumpTo(prog[controller.getNextInstruction()]);
                }else{
                    controller.nextInstruction();
                }
                break;
            case skipIfAxIsNotZero:
                if (!(register.AxIsZero())){
                    controller.nextInstruction();
                }
                break;
            case printAx:
                IO.print(register.getAx());
                break;
            case printChar:
                IO.printChar(register.getAx());
                break;
        }
    }

    private void pushVal(){
        if (!stack.isFull()) {
            stack.push(register.getAx());
        }else {
            register.loadAx(0);
        }
    }

    private void popVal(){
        if (!stack.isEmpty()){
            register.loadAx(stack.pop());
        }else{
            register.loadAx(0);
        }
    }
}
