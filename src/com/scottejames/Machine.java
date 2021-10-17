package com.scottejames;

import java.awt.color.ICC_ColorSpace;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Machine {
    public final Memory memory;
    int programSize = 0;

    public Machine(File inputData) throws IOException {
        memory = new Memory();
        loadInputData(inputData);

    }
    public void printListing(){
        for (int i = 0; i < programSize ; i++){
            int opCode = memory.getMainMemory();
            Instruction instruction = InstructionFactory.getInstruction(opCode,memory);
//            System.err.println(Integer.toHexString(memory.getInstructionPointer()) + ":" + instruction);
            memory.simpleIncrementInstructionPointer(instruction.getOffset());
        }
    }
    public void run(){

        memory.start();
        while (memory.isRunning()){
            int opCode = memory.getMainMemory();
            Instruction instruction = InstructionFactory.getInstruction(opCode,memory);
//            System.err.println(Integer.toHexString(memory.getInstructionPointer()) + ":" + instruction);
            instruction.execute();
        }
    }

    private void loadInputData(File inputData) throws IOException {
        DataInputStream dataIn = new DataInputStream(new FileInputStream(inputData));
        byte[] intData = new byte[2];

        int currentIndex = 0;
        while (dataIn.available() > 0) {
            dataIn.readFully(intData);
            // turn the 16-bit little-endian pair into an integer
            int value = ByteBuffer.wrap(intData).order(ByteOrder.LITTLE_ENDIAN).getChar();
            memory.setMainMemory(currentIndex++, value);
        }
        programSize = currentIndex;
        dataIn.close();
    }
}

