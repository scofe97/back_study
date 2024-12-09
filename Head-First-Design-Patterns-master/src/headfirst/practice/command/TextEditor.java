package headfirst.practice.command;

public class TextEditor {

    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void appendText(String appendText) {
        this.text += appendText;
    }

}
