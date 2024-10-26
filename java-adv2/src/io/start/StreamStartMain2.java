package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false); // append(이어쓰기 여부)
        byte[] input = {65, 66, 67, 68};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        int readCount = fis.read(buffer, 0, 10); // 시작 지점, 읽을 길이
        System.out.println("readCount = " + readCount);
        System.out.println(Arrays.toString(buffer));
        fis.close(); // 자바에서 외부 자원은 무조건 닫아야한다. (GC가 안됨)

    }
}
