package com.scottejames;

public class OpOut extends Instruction {

    private char result;
    public OpOut(Memory memory) {
        super(memory);
        result = (char)this.getParameterValue(1);
        offset = 2;

    }

    @Override
    void execute() {
        System.out.print(result);
        memory.simpleIncrementInstructionPointer(offset);
    }

    @Override
    public String toString(){
        return "<OpOut " + result + " >";
    }
}
