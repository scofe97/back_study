package chapter4;

import org.example.chapter4.template.Book;
import org.example.chapter4.template.FictionBook;
import org.example.chapter4.template.NonFictionBook;
import org.junit.jupiter.api.Test;

public class Chapter4Test {

    @Test
    void templateTest(){
        Book fictionBook = new FictionBook();
        fictionBook.readBook();

        System.out.println("-----");

        Book nonFictionBook = new NonFictionBook();
        nonFictionBook.readBook();
    }

    @Test
    void test2(){

    }

}
