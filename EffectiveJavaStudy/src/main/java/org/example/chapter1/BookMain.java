package org.example.chapter1;

public class BookMain {
    public static void main(String[] args) {
        Ebook ebook = Book.getEbook();
        AudioBook audioBook = Book.getAudioBook();
        PrintBook printBook = Book.getPrintBook();
        Book book = Book.getBook(450);
    }
}
