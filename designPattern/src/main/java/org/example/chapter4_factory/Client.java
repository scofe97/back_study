package org.example.chapter4_factory;

import org.example.chapter4_factory.message.Message;

public class Client {

	public static void main(String[] args) {
		printMessage(new JSONMessageCreator());
		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println("msg = " + msg);
	}
}
