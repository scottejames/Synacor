package com.scottejames;

public class OpSet extends Instruction {
    int a,b;
    public OpSet(Memory memory) {
        super(memory);
        a = getParameter(1);
        b = getParameterValue(2);
        offset = 3;
    }

    @Override
    void execute() {
        memory.setRegister(a,b);

        memory.simpleIncrementInstructionPointer(offset);
    }

    @Override
    public String toString(){
        return "<OpSet " + a + ", "+ b + " >";
    }
}
