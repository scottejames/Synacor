package com.scottejames;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File input = new File("/Users/scottejames/IdeaProjects/Synacor/Resources/challenge.bin");
        Machine machine = new Machine(input);
        machine.run();

    }
}
