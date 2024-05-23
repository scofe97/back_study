package org.example.chapter4_factory;


import org.example.chapter4_factory.message.JSONMessage;
import org.example.chapter4_factory.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
