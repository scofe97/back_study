package network.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class ChatSession implements Runnable {

    private final Socket socket;
    private String name;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final ChatSessionManager manager;
    private boolean closed = false;

    public ChatSession(Socket socket, String name, ChatSessionManager manager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.manager = manager;
        this.manager.add(this);
    }

    @Override
    public void run() {

        try {
            while (true) {
                String received = input.readUTF();
                log(name + ": " + received);

                if (received.startsWith("/")) {
                    handleCommand(output, received);
                }

                if (received.equals("exit")) {
                    break;
                }

                output.writeUTF(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            manager.remove(this);
            close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

    private synchronized void changeName(String changeName) {
        name = changeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void handleCommand(DataOutputStream output, String command) throws IOException {
        // 명령어에 따라 처리
        switch (command.split(":")[0]) {
            case "/join":
                for (ChatSession chatSession : manager.getList()) {
                    chatSession.output.writeUTF(getName() + " 유저가 참여했습니다." + "\n");
                }
                break;
            case "/chat":
                for (ChatSession chatSession : manager.getList()) {
                    chatSession.output.writeUTF(getName() + ": " + command.split(":")[1] + "\n");
                }
                break;
            case "/change":
                for (ChatSession chatSession : manager.getList()) {
                    chatSession.output.writeUTF("이름이 변경되었습니다. " + getName() + " -> " + command.split(":")[1] + "\n");
                }
                changeName(command.split(":")[1]);
                break;
            case "/users":
                for (ChatSession chatSession : manager.getList()) {
                    output.writeUTF("참가유저: " + chatSession.getName() + "\n");
                }
                break;
            case "/exit":
                for (ChatSession chatSession : manager.getList()) {
                    chatSession.output.writeUTF(getName() + "가 채팅을 종료했습니다." + "\n");
                }
                break;
            default:
                output.writeUTF("알 수 없는 명령어: " + command + "\n");
                break;
        }
    }
}
