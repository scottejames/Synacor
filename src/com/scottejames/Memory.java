package com.scottejames;

import java.util.Stack;

public class Memory {
    private final int NUM_REGISTERS = 8;
    private final int MEM_SIZE = 32768;
    private final int[] registers;
    private final int[] mainMemory;
    private final Stack<Integer> stack;

    private int instructionPointer = 0;
    private boolean isRunning = false;

    public Memory(){
        registers = new int[NUM_REGISTERS];
        mainMemory = new int[MEM_SIZE];
        stack = new Stack<>();

    }

    public boolean isRunning() {
        return isRunning;
    }
    public void start(){
        isRunning = true;
    }
    public void stop(){
        isRunning = false;
    }
    public void setMainMemory(int index, int value) {
        mainMemory[index] = value;
    }
    public int getMainMemory(){
        return mainMemory[instructionPointer];
    }
    public int getMainMemoryOffset(int offset){
        return mainMemory[instructionPointer + offset];
    }
    public int getMainMemory(int index) {
        return mainMemory[index];
    }
    public int getRegisterOrValue(int index) {
        if (isRegisterIndex(index)) {
            int registerIndex = index - MEM_SIZE;
            return registers[registerIndex];
        } else {
            return index;
        }
    }
    public int getInstructionPointer(){
        return this.instructionPointer;
    }
    public void setInstructionPointer(int i){
        this.instructionPointer = i;
    }

    public void simpleIncrementInstructionPointer(int offSet){
        int i = getInstructionPointer();
        i = Math.floorMod(i + offSet,getTotalMemorySize());
        this.instructionPointer = i;

    }
    public void setRegister(int index, int value) {
        if (isRegisterIndex(index)) {
            int registerIndex = index - MEM_SIZE;
            registers[registerIndex] = value;
        } else {
            throw new IllegalArgumentException("Tried to access register with invalid index " + index);
        }
    }

    private boolean isRegisterIndex(int index) {
        if (index >= 32776)
            throw new IllegalArgumentException("Invalid index " + index);
        return index < MEM_SIZE + NUM_REGISTERS && index >= MEM_SIZE;
    }
    public int getTotalMemorySize() {
        return MEM_SIZE;
    }

    public void pushOnStack(int value) {
        stack.push(value);
    }

    public int popFromStack() {
        return stack.pop();
    }

    public boolean stackIsEmpty() {
        return stack.isEmpty();
    }
}
