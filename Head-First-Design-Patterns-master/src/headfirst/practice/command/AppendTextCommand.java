package headfirst.practice.command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public final class AppendTextCommand implements Command {
    private final TextEditor editor;
    private String textToAppend;
    private String oldText;

    public AppendTextCommand(TextEditor editor, String textToAppend) {
        this.editor = editor;
        this.textToAppend = textToAppend;
    }

    @Override
    public void execute() {
        oldText = editor.getText();
        editor.appendText(textToAppend);
    }

    @Override
    public void undo() {
        if (oldText != null) {
            editor.setText(oldText);
        }
    }

    @Override
    public void store(OutputStream out) throws IOException {
        // 첫바이트에 'A'를 명령 타입으로 쓴다.
        out.write('A');
        out.write(textToAppend.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void load(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        int len;
        while ((len = in.read(temp)) != -1) {
            buffer.write(temp, 0, len);
        }
        this.textToAppend = buffer.toString(StandardCharsets.UTF_8);
    }

    public String getTextToAppend() {
        return textToAppend;
    }
}

