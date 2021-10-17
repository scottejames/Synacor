package com.scottejames;

public class OpJmp extends Instruction {
    public int result;
    public OpJmp(Memory memory) {
        super(memory);
        result = this.getParameterValue(1);
        offset = 2;

    }

    @Override
    void execute() {
        memory.setInstructionPointer(result);
    }
    @Override
    public String toString(){
        return "<OpJmp " + result + " >";
    }

}
