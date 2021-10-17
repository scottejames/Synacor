package com.scottejames;

public class OpOr extends Instruction {
    int a;
    int b;
    int c;

    public OpOr(Memory memory) {
        super(memory);
        offset = 4;
        a = getParameter(1);
        b = getParameterValue(2);
        c = getParameterValue(3);
    }
    @Override
    void execute() {
        memory.setRegister(a,b | c);
        memory.simpleIncrementInstructionPointer(offset);
    }
}
