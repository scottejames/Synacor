package com.scottejames;

public class OpHalt extends Instruction {

    public OpHalt(Memory memory) {
        super(memory);
        offset = 1;

    }

    @Override
    void execute() {
        memory.stop();
    }

    @Override
    public String toString(){
        return "<OpHalt>";
    }
}
