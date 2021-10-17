package com.scottejames;

public class OpGt extends Instruction {
    int a;
    int b;
    int c;

    public OpGt(Memory memory) {
        super(memory);
        offset = 4;
        a = getParameter(1);
        b = getParameterValue(2);
        c = getParameterValue(3);

    }

    @Override
    void execute() {
        if (b > c)
            memory.setRegister(a,1);
        else
            memory.setRegister(a,0);
        memory.simpleIncrementInstructionPointer(offset);
    }

}
