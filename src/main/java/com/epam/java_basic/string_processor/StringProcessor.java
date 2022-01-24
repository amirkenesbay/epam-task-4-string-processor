package com.epam.java_basic.string_processor;

import java.util.Arrays;

/**
 *  Useful methods for string processing
 */
public class StringProcessor {

    public String findShortestLine(String[] lines) {
        String shortest = lines[0];

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() < shortest.length()) {
                shortest = lines[i];
            }
        }
        return shortest;
    }

    public String findLongestLine(String[] lines) {
        String longest = lines[0];

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() > longest.length()) {
                longest = lines[i];
            }
        }
        return longest;
    }

    public String[] findLinesShorterThanAverageLength(String[] lines) {
        int average = 0;
        String[] result = new String[lines.length-1];
        for (String s : lines) {
            average += s.length();
        }
        average /= lines.length;

        System.out.println("3) Lines shorter than average length:");
        for (String shorterThanAverage : lines) {
            if (shorterThanAverage.length() < average) {
                System.arraycopy(lines, 0, result, 0, lines.length - 1);
            }
        }
        return result;
    }

    public String[] findLinesLongerThanAverageLength(String[] lines) {
        int average = 0;
        String[] result = new String[lines.length-2];
        for (String s : lines) {
            average += s.length();
        }
        average /= lines.length;
        String r = "";
        System.out.println("3) Lines shorter than average length:");
        for (String shorterThanAverage : lines) {
            if (shorterThanAverage.length() > average) {
                r = shorterThanAverage;
            }
        }
        Arrays.fill(result, r);
        return result;
    }

    /**
     * Find word with minimum various characters. Return first word if there are a few of such words.
     * @param words Input array of words
     * @return First word that consist of minimum amount of various characters
     */

    public String findWordWithMinimumVariousCharacters(String[] words) {
        String shortest = words[0];
        String[] elements = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            elements[i] = removeDuplicates(words[i]);
        }
        for (int i = 1; i < elements.length; i++) {
            if (elements[i].length() < shortest.length()) {
                shortest = words[i];
                System.out.println("5) Word contains minimum various characters: " + shortest);
                return shortest;
            } else {
                return "";
            }
        }
        return shortest;
    }

    public String removeDuplicates(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i));
            }
        }
        return result;
    }

    /**
     * Find word containing only of various characters. Return first word if there are a few of such words.
     * @param words Input array of words
     * @return First word that containing only of various characters
     */
    public String findWordConsistingOfVariousCharacters(String[] words) {
        int count = 0;
        for (String element : words) {
            char[] chars = String.valueOf(element).toCharArray();
            if (isOnlyDifferentCharacters(chars)) {
                count++;
                if (count == 1) {
                    System.out.println("6) Word contains only various characters: " + element + " и " + count + "-е по счету");
                    return element;
                }
            }
        }
        return "";
    }

    public boolean isOnlyDifferentCharacters(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Find word containing only of digits. Return second word if there are a few of such words.
     * @param words Input array of words
     * @return Second word that containing only of digits
     */
    public String findWordConsistingOfDigits(String[] words) {
        int count = 0;
        String lastFound = null;
        for (String element : words) {
            if (isOnlyDigits(element)) {
                lastFound = element;
                count++;
                if (count == 2) {
                    System.out.println("Число, состоящее только из различных цифр: " + element + " и " + count + "-е по счету");
                    return element;
                }
            }
        }
        if (lastFound != null) {
            System.out.println("Число, состоящее только из различных цифр: " + lastFound);
            return lastFound;
        } else {
            System.out.println("Таких чисел нет!");
            return null;
        }
    }

    public boolean isOnlyDigits(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < '0' || word.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
