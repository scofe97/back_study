package chat.client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private Client clinet;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client clinet) {
        this.input = input;
        this.clinet = clinet;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                System.out.println("received = " + received);
            }
        } catch (IOException e) {
            log(e);
        }finally {
            clinet.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("readHandler 종료");
    }
}
