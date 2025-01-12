package com.zipcodewilmington;
import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean found = false;
        for (String x : array) {
            if (x == value) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reversed = Arrays.copyOf(array, array.length);

        for (int i = 0; i < (reversed.length)/2; i++) {
            String temp = reversed[i];
            reversed[i] = reversed[reversed.length-i-1];
            reversed[reversed.length-i-1] = temp;
        }
        return reversed;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean palindrome = false;
        String[] reversed = StringArrayUtils.reverse(array);
        if (Arrays.equals(array, reversed)) {
            palindrome = true;
        }
        return palindrome;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String check = Arrays.toString(array);
        check = check.toLowerCase();
        boolean pangram = true;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!check.contains(String.valueOf(ch))) {
                pangram = false;
                break;
            }
        }

        return pangram;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurrences = 0;

        for (int i=0; i<array.length; i++) {
            if (value == array[i]){
                occurrences++;
            }
        }
        return occurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] updated = new String[array.length - 1];

        for  (int i=0, j = 0; i<array.length; i++) {
            if (array[i] != valueToRemove) {
                updated[j++] = array[i];
            }
        }
        return updated;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> builtArray = new ArrayList<>();
        String lastString = "";

        for (int i = 0; i < array.length; i++) {
            if (array[i] != lastString) {
                builtArray.add(array[i]);
                lastString = array[i];
            }
        }
        String[] removed = builtArray.toArray(new String[0]);
        return removed;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List removed = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length) {
                String next = array[i];
                while (array[i].equals(array[i+1])) {
                    next += array[i];
                    i++;
                    if (i + 1 == array.length) {
                        break;
                    }
                }
                removed.add(next);
            } else {
                removed.add(array[i]);
            }
        }
        String[] combined = new String[removed.size()];
        removed.toArray(combined);
        return combined;
    }

}