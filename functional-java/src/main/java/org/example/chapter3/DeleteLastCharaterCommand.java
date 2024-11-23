package org.example.chapter3;

public class DeleteLastCharaterCommand implements TextEditorCommand{

    private final TextEditor textEditor;

    public DeleteLastCharaterCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public String execute() {
        textEditor.deleteLast();
        return "Deleted last character";
    }
}
