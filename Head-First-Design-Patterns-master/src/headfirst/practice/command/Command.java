package headfirst.practice.command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Command {
    void execute();

    void undo();

    void store(OutputStream outputStream) throws IOException;

    void load(InputStream inputStream) throws IOException;
}
