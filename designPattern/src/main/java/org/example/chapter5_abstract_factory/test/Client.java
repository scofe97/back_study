package org.example.chapter5_abstract_factory.test;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Client {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        System.out.println("factory.getClass() = " + factory.getClass());

        DocumentBuilder builder = factory.newDocumentBuilder();
        System.out.println("builder.getClass() = " + builder.getClass());

        Document doc = builder.newDocument();
        System.out.println("doc.getClass() = " + doc.getClass());
    }
}

// factory.getClass() = class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
// builder.getClass() = class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl
// doc.getClass() = class com.sun.org.apache.xerces.internal.dom.DocumentImpl
