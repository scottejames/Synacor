package com.scottejames;

public class OpAdd extends Instruction {
    int reg = 0;
    int a = 0;
    int b = 0;
    public OpAdd(Memory memory) {
        super(memory);
        offset = 4;

        reg = getParameter(1);
        a = getParameterValue(2);
        b = getParameterValue(3);
    }

    @Override
    void execute() {
        memory.setRegister(reg,Math.floorMod( a + b,memory.getTotalMemorySize()));
        memory.simpleIncrementInstructionPointer(offset);
    }

    public String toString(){
        return "<OpAdd " + reg + ",= " + a + "+ " + b + " >";
    }

}
