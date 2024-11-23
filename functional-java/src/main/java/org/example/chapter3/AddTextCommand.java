package org.example.chapter3;

public class AddTextCommand implements TextEditorCommand{

    private final TextEditor textEditor;
    private final String textToAdd;

    public AddTextCommand(TextEditor textEditor, String textToAdd) {
        this.textEditor = textEditor;
        this.textToAdd = textToAdd;
    }

    @Override
    public String execute() {
        textEditor.addText(textToAdd);
        return "Added " + textToAdd;
    }
}
