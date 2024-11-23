package org.example.chapter3;

public class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        this.text = new StringBuilder();
    }

    public void executeCommand(TextEditorCommand command) {
        String result = command.execute();
        System.out.println("Command executed: " + result);
    }

    public void addText(String textToAdd) {
        this.text.append(textToAdd);
    }

    public void deleteLast() {
        if (this.text.length() > 0) {
            this.text.deleteCharAt(this.text.length() - 1);
        }
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
