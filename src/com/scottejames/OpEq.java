package com.scottejames;

public class OpEq extends Instruction {
    int reg = 0;
    int a = 0;
    int b = 0;

    public OpEq(Memory memory) {
        super(memory);
        offset = 4;

        reg = getParameter(1);
        a = getParameterValue(2);
        b = getParameterValue(3);
    }

    @Override
    public void execute() {
        if (a==b)
            memory.setRegister(reg,1);
        else
            memory.setRegister(reg,0);
        memory.simpleIncrementInstructionPointer(offset);
    }

    @Override
    public String toString(){
            return "<OpEq " + reg + ",= " + a + "== " + b + " >";
        }
}
