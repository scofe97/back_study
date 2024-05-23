package org.example.chapter4_factory;


import org.example.chapter4_factory.message.Message;
import org.example.chapter4_factory.message.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
