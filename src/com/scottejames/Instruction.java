package com.scottejames;

public abstract class Instruction {

    protected Memory memory = null;
    protected int offset = 0;

    public Instruction(Memory memory){
        this.memory = memory;
    }
    public int getParameterValue(int c){
        int parameter = memory.getMainMemoryOffset(c);
        int result = memory.getRegisterOrValue(parameter);
        return result;
    }
    public int getParameter(int c){
        int parameter = memory.getMainMemoryOffset(c);
        return parameter;
    }
    abstract void execute();
    public int getOffset(){
        return offset;
    }
}
