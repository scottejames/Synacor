package com.scottejames;

public class OpPop extends Instruction {
    public int reg = 0;
    public OpPop(Memory memory) {
        super(memory);
        offset = 2;
        reg = getParameter(1);
    }

    @Override
    void execute() {
        int value = memory.popFromStack();
        memory.setRegister(reg, value);
        memory.simpleIncrementInstructionPointer(offset);

    }
}
