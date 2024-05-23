package org.example.chapter4_factory.message;

public class JSONMessage extends Message {

	@Override
	public String getContent() {
		return "{\"JSON]\":[]}";
	}

	@Override
	public String toString() {
		return "JSONMessage{}";
	}
}
