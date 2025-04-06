package org.ahmet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfacesTest {

    @Test
    public void testDoubleSupplier() {
        DoubleSupplier doubleSupplier = () -> 3.14;
        assertEquals(3.14, doubleSupplier.getAsDouble());
    }

    @Test
    public void testLongSupplier() {
        LongSupplier longSupplier = () -> 123456789L;
        assertEquals(123456789L, longSupplier.getAsLong());
    }

    @Test
    public void testBooleanSupplier() {
        BooleanSupplier booleanSupplier = () -> true;
        assertTrue(booleanSupplier.getAsBoolean());
    }

    @Test
    public void testSupplier() {
        Supplier<String> supplier = () -> "Hello from Supplier!";
        assertEquals("Hello from Supplier!", supplier.get());
    }

    @Test
    public void testFunction() {
        Function<String, Integer> stringLength = String::length;
        assertEquals(5, stringLength.apply("Hello"));
    }

    @Test
    public void testBiFunction() {
        BiFunction<String, String, String> concatenate = String::concat;
        assertEquals("Hello, World!", concatenate.apply("Hello, ", "World!"));
    }

    @Test
    public void testUnaryOperator() {
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        assertEquals("HELLO", toUpperCase.apply("hello"));
    }

    @Test
    public void testBinaryOperator() {
        BinaryOperator<Integer> add = Integer::sum;
        assertEquals(15, add.apply(5, 10));
    }

    @Test
    public void testIntStream() {
        IntStream intStream = IntStream.range(1, 5);
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, intStream.toArray());
    }

    @Test
    public void testOptional() {
        Optional<String> optional = Optional.of("Hello");
        assertTrue(optional.isPresent());
        assertEquals("Hello", optional.get());
    }

    @Test
    public void testStream() {
        List<String> list = Arrays.asList("A", "B", "C");
        List<String> result = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    public void testCompletableFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello from CompletableFuture!");
        assertEquals("Hello from CompletableFuture!", future.join());
    }

    @Test
    public void testStreamCreation() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    public void testStreamFromArray() {
        String[] array = {"a", "b", "c"};
        List<String> result = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    public void testStreamOfValues() {
        List<String> result = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    public void testInfiniteStream() {
        List<Integer> result = Stream.iterate(0, n -> n + 1).limit(5).collect(Collectors.toList());
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), result);
    }

    @Test
    public void testStreamFromList() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    public void testStreamFromIntArray() {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> result = Arrays.stream(array).boxed().collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    @Test
    public void testStreamFromDoubleArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        List<Double> result = Arrays.stream(array).boxed().collect(Collectors.toList());
        assertEquals(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0), result);
    }

    @Test
    public void testStreamFromLongArray() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        List<Long> result = Arrays.stream(array).boxed().collect(Collectors.toList());
        assertEquals(Arrays.asList(1L, 2L, 3L, 4L, 5L), result);
    }

    @Test
    public void testStreamFromShortArray() {
        short[] array = {1, 2, 3, 4, 5};
        List<Short> result = IntStream.range(0, array.length)
                .mapToObj(i -> array[i])
                .collect(Collectors.toList());
        assertEquals(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), result);
    }

    @Test
    public void testStreamFromByteArray() {
        byte[] array = {1, 2, 3, 4, 5};
        List<Byte> result = IntStream.range(0, array.length)
                .mapToObj(i -> array[i])
                .collect(Collectors.toList());
        assertEquals(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), result);
    }

}