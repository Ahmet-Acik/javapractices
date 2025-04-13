package org.ahmet.streams;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {


        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] uniqueSorted = Arrays.stream(arr).distinct().sorted().toArray();

        System.out.println("Original array: " + Arrays.toString(uniqueSorted));
        if (uniqueSorted.length < 2) {
            System.out.println("No second largest number.");
        } else {
            System.out.println("Second largest: " + uniqueSorted[uniqueSorted.length - 2]);
        }

        System.out.println("Second largest using method: " + findSecondLargest(arr));

    }

    /**
     * Finds the second largest number in an array.
     *
     * @param arr the input array
     * @return the second largest number, or null if not found
     */
    public static Integer findSecondLargest(int[] arr) {
        int[] uniqueSorted = Arrays.stream(arr).distinct().sorted().toArray();
        if (uniqueSorted.length < 2) {
            return null; // No second largest number
        } else {
            return uniqueSorted[uniqueSorted.length - 2];
        }
    }

    /**
     * Finds the second largest number in an array using a custom method.
     *
     * @param arr the input array
     * @return the second largest number, or null if not found
     */
    public static Integer findSecondLargestCustom(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? null : second; // No second largest number

} }

