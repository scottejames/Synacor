package com.scottejames;

public class OpCall extends Instruction {
    int a;

    public OpCall(Memory memory) {
        super(memory);
        a = getParameterValue(1);
        offset = 2;
    }

    @Override
    void execute() {
        int c = memory.getInstructionPointer();
        memory.pushOnStack(c + offset);
        memory.setInstructionPointer(a);
    }

}
