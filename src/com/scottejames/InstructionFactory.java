package com.scottejames;

public class InstructionFactory {
    public static Instruction getInstruction(int opCodeId, Memory memory) {
        switch (opCodeId) {
            case 0:
                return new OpHalt(memory);
            case 1:
                return new OpSet(memory);
            case 2:
                return new OpPush(memory);
            case 3:
                return new OpPop(memory);
            case 4:
                return new OpEq(memory);
            case 5:
                return new OpGt(memory);
            case 6:
                return new OpJmp(memory);
            case 7:
                return new OpJt(memory);
            case 8:
                return new OpJf(memory);
            case 9:
                return new OpAdd(memory);
            case 10:
                return new OpMult(memory);
            case 12:
                return new OpAnd(memory);
            case 13:
                return new OpOr(memory);
            case 14:
                return new OpNot(memory);
            case 17:
                return new OpCall(memory);
            case 19:
                return new OpOut(memory);
            case 21:
                return new OpNoop(memory);
            default:
                throw new IllegalArgumentException("Opcode is not legal when creating instruction " + opCodeId);
        }
    }
}
