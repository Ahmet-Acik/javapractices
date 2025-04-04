package org.ahmet.streams;

import java.util.*;
import java.util.stream.*;

public class ArrayPracticeTwo {

    // 1. Find Largest and Smallest
    public static void largestAndSmallest(int[] arr) {
        Arrays.stream(arr).max().ifPresent(max -> System.out.println("Max: " + max));
        Arrays.stream(arr).min().ifPresent(min -> System.out.println("Min: " + min));
    }

    // 2. Second Largest
    public static void secondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("No second largest.");
            return;
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("No second largest.");
        } else {
            System.out.println("Second Largest: " + second);
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

    // Additional array operations using streams

    // 11. Sum of All Elements
    public static int sumOfElements(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    // 12. Average of All Elements
    public static double averageOfElements(int[] arr) {
        return Arrays.stream(arr).average().orElse(Double.NaN);
    }

    // 13. Count of Even Numbers
    public static long countEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(n -> n % 2 == 0).count();
    }

    // 14. Product of All Elements
    public static int productOfElements(int[] arr) {
        return Arrays.stream(arr).reduce(1, (a, b) -> a * b);
    }

    // 15. Find All Prime Numbers
    public static List<Integer> findAllPrimes(int[] arr) {
        return Arrays.stream(arr)
                .filter(ArrayPracticeTwo::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 16. Find All Palindromic Numbers
    public static List<Integer> findAllPalindromes(int[] arr) {
        return Arrays.stream(arr)
                .filter(ArrayPracticeTwo::isPalindrome)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // 17. Find the Longest Increasing Subsequence
    public static List<Integer> longestIncreasingSubsequence(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        return lis;
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

        // Additional array operations
        System.out.println("Sum of elements: " + sumOfElements(example));
        System.out.println("Average of elements: " + averageOfElements(example));
        System.out.println("Count of even numbers: " + countEvenNumbers(example));
        System.out.println("Product of elements: " + productOfElements(example));
        System.out.println("All prime numbers: " + findAllPrimes(example));
        System.out.println("All palindromic numbers: " + findAllPalindromes(example));
        System.out.println("Longest increasing subsequence: " + longestIncreasingSubsequence(example));
    }
}