package headfirst.practice.command;

import java.io.*;

public class MainCommand {
    public static void main(String[] args) throws IOException {
        TextEditor editor = new TextEditor();
        CommandInvoker invoker = new CommandInvoker(editor);

        // Hello World 적재
        invoker.invoke(new ChangeTextCommand(editor, "Hello"));
        invoker.invoke(new AppendTextCommand(editor, " World"));
        System.out.println("Current textL " + editor.getText());

        // 현재 상태 파일로 저장
        try (OutputStream out = new FileOutputStream("command.log")) {
            invoker.storeLastCommand(out);
        }

        // 텍스트 변경
        invoker.invoke(new ChangeTextCommand(editor, "Something else"));
        System.out.println("Current text: " + editor.getText());

        // 파일에서 명령을 로드하고 실행
        try(InputStream in = new FileInputStream("command.log")) {
            invoker.loadCommand(in);
        }

        // 로드된 명령어 실행
        System.out.println("Current text: " + editor.getText());
    }
}
