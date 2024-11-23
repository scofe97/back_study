package org.example.chapter5;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestMain5_3 {

    public static List<String> filterAlbums(Map<Integer, List<String>> albums, int minimumYear) {

        record AlbumsPerYear(int year, List<String> titles) {
            public AlbumsPerYear(Map.Entry<Integer, List<String>> entry) {
                this(entry.getKey(), entry.getValue());
            }

            public static Predicate<AlbumsPerYear> minimumYear(int year) {
                return albumsPerYear -> albumsPerYear.year() >= year;
            }

            public static Comparator<AlbumsPerYear> sortByYear() {
                return Comparator.comparing(AlbumsPerYear::year);
            }
        }

        return albums.entrySet()
                .stream()
                .map(AlbumsPerYear::new)
                .filter(AlbumsPerYear.minimumYear(minimumYear))
                .sorted(AlbumsPerYear.sortByYear())
                .map(AlbumsPerYear::titles)
                .flatMap(List::stream)
                .toList();
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> albums = new HashMap<>();
        albums.put(2020, Arrays.asList("Album A", "Album B"));
        albums.put(2021, Arrays.asList("Album C", "Album D"));
        albums.put(2019, Arrays.asList("Album E"));

        List<String> filteredAlbums = filterAlbums(albums, 2020);
        System.out.println(filteredAlbums);
    }
}
