package org.example.chapter4_factory;


import org.example.chapter4_factory.message.Message;

/**
 * This is our abstract "creator". 
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {

    public Message getMessage() {
        Message msg = createMessage();

        msg.addDefaultHeaders(); // 헤더추가
        msg.encrypt(); // 암호화

        return msg;
    }

    // 팩토리 메서드
    public abstract Message createMessage();
}
