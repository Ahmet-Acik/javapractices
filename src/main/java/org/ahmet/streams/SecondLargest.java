package org.ahmet.streams;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
       // This program finds the second largest number in an array using Java Streams.
         // It first removes duplicates using distinct(), then sorts the array in ascending order,
            // and finally retrieves the second largest number by accessing the second last element of the sorted array.
        // The program handles the case where there are not enough unique elements to find a second largest number.
        // It prints the original array and the second largest number if it exists.
        // If the array has less than two unique elements, it prints a message indicating that there is no second largest number.
        // The program uses Java Streams to perform these operations in a concise and functional manner.
        // The array is defined with some duplicate values to demonstrate the functionality.


        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] uniqueSorted = Arrays.stream(arr).distinct().sorted().toArray();

        System.out.println("Original array: " + Arrays.toString(uniqueSorted));
        if (uniqueSorted.length < 2) {
            System.out.println("No second largest number.");
        } else {
            System.out.println("Second largest: " + uniqueSorted[uniqueSorted.length - 2]);
        }

        // can we make it as a method?
        // Yes, we can encapsulate the logic into a method that takes an array as input and returns the second largest number.
        // Here's how you can do it:


    }
}
