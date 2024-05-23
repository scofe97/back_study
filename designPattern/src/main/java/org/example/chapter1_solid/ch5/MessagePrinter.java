package org.example.chapter1_solid.ch5;

import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

	//Writes message to a file
	public void writeMessage(Message msg, Formatter formatter, PrintWriter writer) throws IOException {
		writer.println(formatter.format(msg)); //formats and writes message
		writer.flush();
	}
}
