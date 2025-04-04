package org.ahmet.streams;// Java Practice Sheet - Array & Number Problems Using Streams Where Possible

import java.util.*;
import java.util.stream.*;

public class ArrayPracticeOne {

    // 1. Find Largest and Smallest
    public static void largestAndSmallest(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
        System.out.println("Max: " + max + ", Min: " + min);
    }

    // 2. Second Largest
    public static void secondLargest(int[] arr) {
        int[] sortedUnique = Arrays.stream(arr).distinct().sorted().toArray();
        if (sortedUnique.length < 2) {
            System.out.println("No second largest.");
        } else {
            System.out.println("Second Largest: " + sortedUnique[sortedUnique.length - 2]);
        }
    }

    // 3. Check if Sorted
    public static boolean isSorted(int[] arr) {
        return IntStream.range(0, arr.length - 1).allMatch(i -> arr[i] <= arr[i + 1]);
    }

    // 4. Find Duplicates
    public static void findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = Arrays.stream(arr)
                .filter(n -> !seen.add(n))
                .boxed()
                .collect(Collectors.toSet());
        System.out.println("Duplicates: " + duplicates);
    }

    // 5. Remove Duplicates
    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    // 6. Reverse Array
    public static void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println("Reversed: " + Arrays.toString(arr));
    }

    // 7. Find Missing Number (1 to N)
    public static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();
        return expectedSum - actualSum;
    }

    // 8. Most Frequent Element
    public static void mostFrequent(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> most = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        most.ifPresent(entry -> System.out.println("Most Frequent: " + entry.getKey() + " (" + entry.getValue() + ")"));
    }

    // 9. Move Zeros to End
    public static void moveZerosToEnd(int[] arr) {
        int[] result = IntStream.concat(
                Arrays.stream(arr).filter(n -> n != 0),
                Arrays.stream(arr).filter(n -> n == 0))
                .toArray();
        System.out.println("After moving zeros: " + Arrays.toString(result));
    }

    // 10. Check Pair With Sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] example = {1, 3, 2, 3, 4, 0, 0, 5};

        largestAndSmallest(example);
        secondLargest(example);
        System.out.println("Is Sorted: " + isSorted(example));
        findDuplicates(example);
        System.out.println("Without Duplicates: " + Arrays.toString(removeDuplicates(example)));
        reverseArray(example.clone());
        System.out.println("Missing number from 1 to 6: " + findMissingNumber(new int[]{1, 2, 4, 5, 6}, 6));
        mostFrequent(example);
        moveZerosToEnd(example);
        System.out.println("Has pair with sum 6: " + hasPairWithSum(example, 6));
    }
}
