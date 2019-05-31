package com.zipcodewilmington;

import java.util.Arrays;
import java.util.ArrayList;

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
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        Boolean exists = false;

        for(String string : array) {

            if(string.equals(value)) exists = true;

        }

        return exists;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        String[] reversed = new String[array.length];
        Integer count = array.length - 1;

        for(String string : array) {

            reversed[count] = string;
            count--;

        }

        return reversed;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        //Set up
        String[] reversed = new String[array.length];
        Integer count = array.length - 1;

        // Reverse array
        for(String string : array) {

            reversed[count] = string;
            count--;

        }

        //compare arrays and return
        return Arrays.equals(array, reversed);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        boolean result = true;

        Character[] alphabet = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(Character character : alphabet) {

            boolean stillTrue = false;

            for (String string : array) {

                for(int i = 0; i < string.length(); i++) {

                    if(character.equals(string.charAt(i))) stillTrue = true;

                }

            }

            if (!stillTrue) {

                result = false;
                break;
            }
        }

        //Loop through alphabet
        //if a character isn't found then return false


        return result;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        Integer count = 0;

        for(String string : array) {

            if(string.equals(value)) count++;

        }

        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        Integer count = 0;

        for(String string : array) {

            if(string.equals(valueToRemove)) count++;

        }

        String[] newArray = new String[array.length - count];

        count = 0;

        for(String string : array) {

            if(!string.equals(valueToRemove)) {

                newArray[count] = string;
                count++;
            }

        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        String[] noConsecutives = new String[0];
        Integer count = 0;

        for(String string : array) {

            if((noConsecutives.length == 0) || (noConsecutives[count - 1] != string)) {

                //Make a new array
                String[] replace = new String[noConsecutives.length + 1];

                //Copy array
                for(int i = 0; i < noConsecutives.length; i++) {

                    replace[i] = noConsecutives[i];
                }

                noConsecutives = replace;

                // Set string to array
                noConsecutives[count] = string;
                count++;

            }
        }

        return noConsecutives;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        String[] packed = new String[0];
        String lastString = "";
        int index = 0;
        int count = 0;

        //Loop through array
        for(String current : array) {


            //see if current string matches previous
            if(lastString.equals(current)) {

                //if match ammend/concatonate
                StringBuilder build = new StringBuilder(packed[index - 1]);
                build.append(current);
                packed[index - 1] = build.toString();

            }
            else {

                // Increase array size
                if(count < array.length) {

                    String[] placeholder = new String[packed.length + 1];


                    if(packed.length != 0) {
                    int i = 0;
                    for (String shuffle : packed) {

                        placeholder[i] = packed[i];
                        i++;
                        }

                    }

                    packed = placeholder;

                }
                System.out.println(count);

                System.out.println(Arrays.toString(packed));
                //Add to array
                packed[index] = current;
                lastString = current;
                index++;

            }

            count++;
        }
        System.out.println(packed.length);
        System.out.println(Arrays.toString(packed));

        return packed;
    }


}
