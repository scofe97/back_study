package headfirst.practice.command;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CommandInvoker {
    private final CommandHistory history = new CommandHistory();
    private final TextEditor editor;

    public CommandInvoker(TextEditor editor) {
        this.editor = editor;
    }

    public void invoke(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undoLast() {
        Command last = history.pop();
        if (last != null) {
            last.undo();
        }
    }

    public void storeLastCommand(OutputStream out) throws IOException{
        Command last = history.peek();
        if (last != null) {
            last.store(out);
        }
    }

    public void loadCommand(InputStream in) throws IOException {
        int type = in.read();
        if (type == -1) {
            throw new IOException();
        }

        Command cmd;
        switch (type) {
            case 'C' -> {
                cmd = new ChangeTextCommand(editor, ""); // 임시로 빈 문자열
                cmd.load(in); // 나머지 바이트로 newText를 복원
            }
            case 'A' -> {
                cmd = new AppendTextCommand(editor, "");
                cmd.load(in); // 나머지 바이트로 textToAppend 복원
            }
            default -> throw new IOException("Unknown command type: " + (char) type);
        }

        invoke(cmd);

    }

    public void printHistory() {
        history.print();
    }


}
