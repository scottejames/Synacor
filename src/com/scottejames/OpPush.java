package com.scottejames;

public class OpPush extends Instruction {
    private int param = 0;
    public OpPush(Memory memory) {
        super(memory);
        offset = 2;
        param = getParameterValue(1);
    }

    @Override
    void execute() {
        memory.pushOnStack(param);
        memory.simpleIncrementInstructionPointer(offset);

    }
}
