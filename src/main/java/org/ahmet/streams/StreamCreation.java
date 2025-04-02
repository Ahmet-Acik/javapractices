package org.ahmet.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {

        // From a collection
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> streamFromList = list.stream();
        streamFromList.forEach(System.out::println);

        // From an array
        String[] array = {"a", "b", "c"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);


        // From individual values
        Stream<String> streamOfValues = Stream.of("a", "b", "c");
        streamOfValues.forEach(System.out::println);

        // Infinite stream
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
        System.out.printf("Infinite stream: %s%n", infiniteStream.limit(5).toList());
    }
}