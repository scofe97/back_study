package org.example.chapter6;

import java.util.*;
import java.util.stream.Stream;

public class TestMain6_1 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(Stream.of(
                new Book("The Dragon's Tale", 2001, Genre.FANTASY),
                new Book("Love in the Rain", 2005, Genre.ROMANCE),
                new Book("Soccer Legends", 2010, Genre.SPORTS),
                new Book("Mystic Woods", 1999, Genre.FANTASY),
                new Book("Hearts Together", 2012, Genre.ROMANCE),
                new Book("Basketball Stars", 2018, Genre.SPORTS),
                new Book("Elven Realms", 2003, Genre.FANTASY),
                new Book("Romance by the Lake", 2007, Genre.ROMANCE),
                new Book("Champions of the Field", 2015, Genre.SPORTS),
                new Book("The Wizard's Journey", 2002, Genre.FANTASY),
                new Book("A Love Story", 2013, Genre.ROMANCE),
                new Book("The Running Track", 2019, Genre.SPORTS),
                new Book("Magical Beasts", 2004, Genre.FANTASY),
                new Book("Romantic Nights", 2008, Genre.ROMANCE),
                new Book("Tennis Champs", 2016, Genre.SPORTS),
                new Book("The Enchanted Castle", 2000, Genre.FANTASY),
                new Book("Love and Destiny", 2011, Genre.ROMANCE),
                new Book("Goal Masters", 2017, Genre.SPORTS),
                new Book("Fairyland Adventures", 2006, Genre.FANTASY),
                new Book("Romance Under the Stars", 2014, Genre.ROMANCE),
                new Book("Racing Heroes", 2020, Genre.SPORTS),
                new Book("Dark Sorcery", 2009, Genre.FANTASY),
                new Book("A Kiss to Remember", 2015, Genre.ROMANCE),
                new Book("Cycling Legends", 2021, Genre.SPORTS),
                new Book("The Last Unicorn", 2001, Genre.FANTASY),
                new Book("Summer Romance", 2003, Genre.ROMANCE),
                new Book("Volleyball Victory", 2018, Genre.SPORTS),
                new Book("The Sorcerer's Apprentice", 2007, Genre.FANTASY),
                new Book("Romantic Escape", 2010, Genre.ROMANCE),
                new Book("Baseball Heroes", 2019, Genre.SPORTS)
        ).toList());


        books.sort(Comparator.comparing(Book::title));
        books.forEach(System.out::println);

        List<String> result = books.stream()
                .filter(book -> book.year() < 1970)
                .filter(book -> book.genre() == Genre.FANTASY)
                .map(Book::title)
                .sorted()
                .limit(3L)
                .toList();


        result.stream();
        result.parallelStream();
        result.spliterator();
    }
}
