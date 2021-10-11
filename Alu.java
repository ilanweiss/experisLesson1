package com.exsperis;

public class Alu {
    private Register register;

    public Alu(){}

    public Alu(Register register){
        this.register = register;
    }
    public void addAxToBx() {
        register.loadAx(register.getAx()+register.getBx());
    }

    public void subBxFromAx() {
        register.loadAx(register.getAx()-register.getBx());
    }

    public void multiplyAxWithBx() {
        register.loadAx(register.getAx()*register.getBx());
    }

    public void divAxByBx() {
        register.loadAx(register.getAx()/register.getBx());
    }

}
