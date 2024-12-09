package headfirst.practice.command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ChangeTextCommand implements Command {

    private final TextEditor textEditor;;
    private String newText;
    private String oldText;

    public ChangeTextCommand(TextEditor textEditor, String newText) {
        this.textEditor = textEditor;
        this.newText = newText;
    }

    @Override
    public void execute() {
        oldText = textEditor.getText();
        textEditor.setText(newText);
    }

    @Override
    public void undo() {
        if(oldText != null) {
            textEditor.setText(oldText);
        }
    }

    @Override
    public void store(OutputStream outputStream) throws IOException {
        outputStream.write('C');
        outputStream.write(newText.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void load(InputStream inputStream) throws IOException {
        // 'C' 타입을 이미 읽었다고 가정하고, 나머지 바이트를 모두 읽어 newText로 설정
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];

        int len;
        while ((len = inputStream.read(temp)) != -1) {
            buffer.write(temp, 0, len);
        }
        this.newText = buffer.toString(StandardCharsets.UTF_8);
    }
}
