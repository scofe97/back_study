package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path = " + file.getPath());
        // 절대 경로(처음부터 입력한 모든 경로)
        System.out.println("file.getAbsolutePath = " + file.getAbsolutePath());

        // 정규 경로(경로의 계산이 모두 끝난 경로)
        System.out.println("file.getCanonicalFile() = " + file.getCanonicalFile());

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isFile() ? "F" : "D") + " | " + f.getName());

        }
    }
}
