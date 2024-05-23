package org.example.chapter4_factory.message;

public class TextMessage extends Message {
	
	@Override
	public String getContent() {
		return "Text";
	}

	@Override
	public String toString() {
		return "TextMessage{}";
	}
}
