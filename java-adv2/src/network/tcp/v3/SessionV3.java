package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class SessionV3 implements Runnable {

    private final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String reveived = input.readUTF();
                log("clinet -> server: " + reveived);

                if(reveived.equals("exit")) {
                    break;
                }

                String toSend = reveived + " World!";
                output.writeUTF(toSend);
                log("clinet <- server: " + toSend);
            }

            log("연결 종료: "  + socket);
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
