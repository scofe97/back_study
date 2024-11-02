package network.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ChatClient {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", PORT)) {
            log("클라이언트 시작");
            log("소켓 연결: " + socket);

            // 데이터를 읽기 위한 스레드
            Thread readThread = new Thread(() -> {
                try (DataInputStream input = new DataInputStream(socket.getInputStream())) {
                    while (!socket.isClosed()) {
                        String received = input.readUTF();
                        log("client <- server: " + received);
                    }
                } catch (IOException e) {
                    log("읽기 오류: " + e.getMessage());
                }
            });

            // 데이터를 쓰기 위한 스레드
            Thread writeThread = new Thread(() -> {
                try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                     Scanner scanner = new Scanner(System.in)) {
                    while (!socket.isClosed()) {
                        String toSend = scanner.nextLine();
                        output.writeUTF(toSend);
                        if (toSend.equals("exit")) {
                            socket.close(); // 소켓을 닫아 읽기 스레드도 종료되도록 함
                            break;
                        }
                    }
                } catch (IOException e) {
                    log("쓰기 오류: " + e.getMessage());
                }
            });

            // 스레드 시작
            readThread.start();
            writeThread.start();

            // 스레드의 완료를 기다림
            readThread.join();
            writeThread.join();
        } catch (IOException e) {
            log(e);
        } catch (InterruptedException e) {
            log("스레드 인터럽트 오류: " + e.getMessage());
        }
    }
}
