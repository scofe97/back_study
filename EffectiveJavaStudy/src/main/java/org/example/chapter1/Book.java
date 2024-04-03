package org.example.chapter1;

import java.util.UUID;

public class Book {

    private String id;
    private String title;
    private String author;

    public Book() {}

    private Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public static Ebook getEbook(){
        return new Ebook();
    }

    public static AudioBook getAudioBook(){
        return new AudioBook();
    }

    public static PrintBook getPrintBook(){
        return new PrintBook();
    }

    public static Book getBook(int pages){
        if (pages > 1000) {
            return new Ebook();
        }

        if (pages > 500) {
            return new AudioBook();
        }

        return new PrintBook();
    }

    // from: 매개 변수 하나를 받아서 반환한다.
    public static Book from(Book book) {
        return new Book(book.id, book.title, book.author);
    }

    // of: 매개 변수 여러개를 받아서 반환한다.
    public static Book of(String title, String author) {
        String id = UUID.randomUUID().toString();
        return new Book(id, title, author);
    }

    // valueOf: from, of의 더 상세한 버전이다.
    public static Book valueOf(String bookInfo) {
        String[] parts = bookInfo.split(",");
        String id = UUID.randomUUID().toString();
        return new Book(id, parts[0], parts[1]);
    }

    // 매개 변수로 명시한 인스턴스를 반환, 같은 인스턴스를 보장하지는 않는다.
    public static Book getInstance(String title, String author) {
        return new Book(UUID.randomUUID().toString(), title, author);
    }


}
