package org.example.chapter5;

import org.example.chapter3.Compositor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public record AlbumsPreYear(
        int year,
        List<String> titles
) {

    public AlbumsPreYear(Map.Entry<Integer, List<String>> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public static Predicate<AlbumsPreYear> minimumYear(int year) {
        return albumsPreYear -> albumsPreYear.year() > year;
    }

    public static Comparator<AlbumsPreYear> sortByYear() {
        return Comparator.comparing(AlbumsPreYear::year);
    }
}
