package com.exsperis;

public class VM{
    private Stack stack;
    private Register register;
    private Alu alu;

    public VM(){
        this.stack = new Stack();
        this.register = new Register();
        this.alu = new Alu(register);
    }

    public void run(int[] prog){
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
                    alu.addAxToBx();
                    break;
                case 6:
                    alu.subBxFromAx();
                    break;
                case 7:
                    alu.multiplyAxWithBx();
                    break;
                case 8:
                    alu.divAxByBx();
                    break;
                case 9:
                    i=i+prog[i+1]-1;
                    break;
                case 10:
                    if (register.AxisZero()){
                        i = i+prog[i+1]-1;
                    }else{
                        i++;
                    }
                    break;
                case 11:
                    printAx(register.getAx());
                    break;
            }
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

    private void moveAxToBx() {
        register.moveAxToBx();
    }

    private void moveBxToAx() {
        register.moveBxToAx();
    }

    private void loadToAX(int value){
        register.loadAx(value);
    }

    private void printAx(int ax){
        System.out.print(ax + " ");
    }
}
