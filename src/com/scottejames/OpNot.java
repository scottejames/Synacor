package com.scottejames;

public class OpNot extends Instruction {
    int a;
    int b;

    public OpNot(Memory memory) {
        super(memory);
        offset = 3;
        a = getParameter(1);
        b = getParameterValue(2);
    }

    @Override
    void execute() {
        memory.setRegister(a,unsignedNot(b));
        memory.simpleIncrementInstructionPointer(offset);
    }


    private int unsignedNot(int value) {
        return ~value & 0x7FFF;
    }
}
