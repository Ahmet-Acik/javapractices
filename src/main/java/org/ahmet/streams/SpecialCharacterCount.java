package org.ahmet.streams;

public class SpecialCharacterCount {

    /**
     * Counts the number of special characters in a given string.
     *
     * @param str the input string
     * @return the count of special characters
     * @throws IllegalArgumentException if the input string is null
     */
    public static int countSpecialCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        int count = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of special characters in a given string using streams.
     *
     * @param str the input string
     * @return the count of special characters
     * @throws IllegalArgumentException if the input string is null
     */
    public static int countSpecialCharactersStream(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        return (int) str.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count();
    }

    public static void main(String[] args) {
        String str = "$-+(68then&-)/'@";
        System.out.println("Number of special characters: " + countSpecialCharacters(str));
        System.out.println("Number of special characters (stream): " + countSpecialCharactersStream(str));
    }
    /**
     * Counts the number of special characters in a given string using regex.
     *
     * @param str the input string
     * @return the count of special characters
     * @throws IllegalArgumentException if the input string is null
     */
    public static int countSpecialCharactersRegex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        return str.replaceAll("[a-zA-Z0-9]", "").length();
    }
}