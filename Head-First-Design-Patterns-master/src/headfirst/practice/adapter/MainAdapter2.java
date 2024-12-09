package headfirst.practice.adapter;

import java.io.*;

public class MainAdapter2 {
    public static void main(String[] args) {

        String text = "Hello World";
        try (InputStream byteStream = new ByteArrayInputStream(text.getBytes())) {

            // InputStreamReader 바이트 단위로 읽는 InputStream을 문자 단위로 읽는 Reader로 변환한다.
            Reader reader = new InputStreamReader(byteStream);
            BufferedReader br = new BufferedReader(reader);

            String line = br.readLine();
            System.out.println("Read line: " + line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
