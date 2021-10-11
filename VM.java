package com.exsperis;

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
            switch (opcode) {
                case OpCode.pushAxToStack:
                    pushVal();
                    break;
                case OpCode.popStackToAX:
                    popVal();
                    break;
                case OpCode.moveAxToBx:
                    register.moveAxToBx();
                    break;
                case OpCode.moveBxToAx:
                    register.moveBxToAx();
                    break;
                case OpCode.loadDataToAx:
                    register.loadAx(prog[controller.getNextInstruction()]);
                    controller.nextInstruction();
                    break;
                case OpCode.addBxToAx:
                    alu.addAxToBx();
                    break;
                case OpCode.subBxFromAx:
                    alu.subBxFromAx();
                    break;
                case OpCode.multiplyBxWithAx:
                    alu.multiplyAxWithBx();
                    break;
                case OpCode.divAxByBx:
                    alu.divAxByBx();
                    break;
                case OpCode.jumpTo:
                    controller.jumpTo(prog[controller.getNextInstruction()]);
                    break;
                case OpCode.jumpIfAxIsZero:
                    if (register.AxisZero()){
                        controller.jumpTo(prog[controller.getNextInstruction()]);
                    }else{
                        controller.nextInstruction();
                    }
                    break;
                case OpCode.printAx:
                    print(register.getAx());
                    break;
            }
            controller.nextInstruction();
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

    private void print(int value){
        System.out.printf("%d ",value);
    }
}
