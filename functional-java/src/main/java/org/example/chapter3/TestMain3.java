package org.example.chapter3;

import java.util.function.Function;
import java.util.function.Supplier;

public class TestMain3 {

    public static void main(String[] args) {

        TextEditor textEditor = new TextEditor();
        AddTextCommand addTextCommand = new AddTextCommand(textEditor, "Hello World");
        DeleteLastCharaterCommand deleteLastCharaterCommand = new DeleteLastCharaterCommand(textEditor);

        textEditor.executeCommand(addTextCommand);
        textEditor.executeCommand(deleteLastCharaterCommand);

        Supplier<String> supplier = addTextCommand;
        System.out.println(supplier.get());
    }
}
