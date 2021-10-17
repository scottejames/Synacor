package com.scottejames;

public class OpJf extends Instruction {

    private int lhs;
    private int rhs;

    public OpJf(Memory memory) {
        super(memory);
        lhs = this.getParameterValue(1);
        rhs = this.getParameterValue(2);
        offset = 3;
    }

    @Override
    void execute() {
        if (lhs == 0){
            memory.setInstructionPointer(rhs);
        } else {
            memory.simpleIncrementInstructionPointer(offset);
        }
    }

    @Override
    public String toString(){
        return "<OpJF " + lhs + ", " + rhs + " >";
    }
}
