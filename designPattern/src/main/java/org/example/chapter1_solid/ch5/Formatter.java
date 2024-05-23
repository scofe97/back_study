package org.example.chapter1_solid.ch5;

//Common interface for classes formatting Message object
public interface Formatter {
	
	public String format(Message message) throws FormatException;
	
}
