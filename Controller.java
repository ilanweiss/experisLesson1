package com.exsperis;

public class Controller {

    private int currentInstruction;
    private int nextInstruction;
    private int overflow;
    private final int underflow = -1;

    public Controller(){
    }

    public Controller(int sizeOfProgramList){
        reset(sizeOfProgramList);
    }

    public int getCurrentInstruction() {
        return currentInstruction;
    }

    public int getNextInstruction() {
        return nextInstruction;
    }
    public void jumpTo(int offset){
        if(hasNext(offset)){
                nextInstruction = currentInstruction + offset - 1;
                nextInstruction();
        }else{
        System.out.print("no more instructions");
        }
    }
    public void reset(int sizeOfProgramList){
        currentInstruction = 0;
        nextInstruction = 1;
        overflow = sizeOfProgramList;
    }
    public void nextInstruction(){
        if (hasNext()){
            currentInstruction = nextInstruction;
            nextInstruction++;
        }else{
            System.out.print("no more instructions");
        }
    }

    public boolean hasNext(){
        return (nextInstruction <= overflow);
    }
    private boolean hasNext(int offset){
        return (currentInstruction + offset-1 < overflow && currentInstruction + offset-1 > underflow);
    }

}
