package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        // 폴더는 만들어주지 않음
        // 파일은 새로 생성하고, 기존값 지우고 덮어씀
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false); // append(이어쓰기 여부)
        fos.write(65); // A
        fos.write(66); // B
        fos.write(67); // C
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;
        while((data = fis.read()) != -1) {
            System.out.println("data = " + data);
        }
        fis.close(); // 자바에서 외부 자원은 무조건 닫아야한다. (GC가 안됨)

    }
}
