package io.file;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("file.exists() = " + file.exists());
        boolean created = file.createNewFile();
        System.out.println("created = " + created);

        boolean dirCreated = directory.mkdir();
        System.out.println("dirCreated = " + dirCreated);


//        boolean delete = file.delete();
//        System.out.println("delete = " + delete);

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length() + " bytes");

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("renamed = " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("Instant.ofEpochMilli(lastModified). = " + Instant.ofEpochMilli(lastModified)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
    }
}
