package io.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("Hello World");
        printStream.println(10);
        printStream.println(true);
        printStream.printf("hello %s", "word");
        printStream.close();
    }
}
