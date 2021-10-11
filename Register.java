package com.exsperis;

public class Register {
    private int ax;
    private int bx;

    public Register(){
        reset();
    }

    public int getAx(){
        return ax;
    }

    public int getBx(){
        return bx;
    }

    public void loadAx(int valueToLoad){
        ax = valueToLoad;
    }

    public void moveAxToBx(){
        bx = ax;
    }

    public void moveBxToAx(){
        ax = bx;
    }

    public void reset(){
        ax = 0;
        bx = 0;
    }

    public boolean AxisZero(){
        return (ax==0);
    }
}
