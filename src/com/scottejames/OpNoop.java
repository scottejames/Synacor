package com.scottejames;

public class OpNoop extends Instruction {

    public OpNoop(Memory memory) {
        super(memory);
        offset = 1;
    }

    @Override
    void execute() {
        memory.simpleIncrementInstructionPointer(offset);
    }

    @Override
    public String toString(){
        return "<OpNoop>";
    }
}
