package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // String Declaration and Initialization
        String str1 = "Hello, World!";
        String str2 = new String("Java Programming");

        logger.info("Length of str1: " + str1.length());
        logger.info("Character at index 8 in str1: " + str1.charAt(8));

        // Comparison
        String str3 = "hello, world!";
        logger.info("str1 equals str3 : " + str1.equals(str3)); // case-sensitive
        logger.info("str1 equals str3 : " + str1.equalsIgnoreCase(str3));

        // Concatenation
        logger.info("Concatenation using + operator : " + str1 + " " + str2);
        logger.info("Concatenation using concat function" + str1.concat(str2));

        // Substring
        logger.info("Substring from index 0 to 7: " + str1.substring(7, 12));

        // Search and Indexing
        logger.info("Index of 'World' in str1: " + str1.indexOf("World"));
        logger.info("Last index of 'o' in str1: " + str1.lastIndexOf("o"));
        logger.info("Does str1 contain 'Hello'? " + str1.contains("Hello"));

        // Case Conversion
        logger.info("Uppercase str1: " + str1.toUpperCase());
        logger.info("Lowercase str1: " + str1.toLowerCase());

        // Trim and Strip
        logger.info("  Trim me  ".trim());

        // Splitting and Joining
        String str4 = "apple,orange,banana";
        String[] fruits = str4.split(",");
        logger.info("Split fruits:");
        for (String fruit : fruits) {
            logger.info(" - {}", fruit);
        }
        String joinedFruits = String.join(" | ", fruits);
        logger.info("Joined Fruits: " + joinedFruits);

        // Replace and ReplaceAll
        logger.info("Replace 'apple' with 'mango': " + str4.replace("apple", "mango"));
        logger.info("ReplaceAll regex 'a' with 'b': " + str4.replaceAll("a", "b"));

        // Using StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", StringBuilder!"); // efficient concatenation compared to +
        logger.info("StringBuilder content: {}", sb);

        // String Format
        String formatted = String.format("Hello, %s! You have %d new messages.", "Alice", 5);
        logger.info("Formatted String: " + formatted);

        // ValueOf and Parsing
        int number = 123;
        String numberStr = String.valueOf(number);
        logger.info("String value of number: " + numberStr);
        int parsedNumber = Integer.parseInt(numberStr);
        logger.info("Parsed number: " + parsedNumber);

        // String Pool Behavior
        String literal1 = "Java";
        String literal2 = "Java";
        String object1 = new String("Java"); // new string object created in heap memory
        logger.info("literal1 == literal2: " + (literal1 == literal2));
        logger.info("literal1 == object1: " + (literal1 == object1));
        logger.info("literal1.equals(object1): " + literal1.equals(object1));

        // Arrays
        int arrSize = 10;
        String[] arr = new String[arrSize]; // initializing an array of size 10 that will hold string objects
        logger.info("Initial array values:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "Element" + (i + 1); // Assigning values to the array
            logger.info("arr[{}]: {}", i, arr[i]);
        }

        // Accessing elements
        logger.info("Accessing the 5th element: {}", arr[4]);

        // Modifying elements
        arr[4] = "ModifiedElement";
        logger.info("After modification, 5th element: {}", arr[4]);

        // Iterating over an array using enhanced for loop
        logger.info("Iterating over the array using enhanced for loop:");
        for (String element : arr) {
            logger.info("Element: {}", element);
        }

        // Multidimensional Arrays : Initializing with default values
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        logger.info("Multidimensional array (matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                logger.info("matrix[{}][{}]: {}", i, j, matrix[i][j]);
            }
        }
        
        // Finding the length of the array
        logger.info("Length of arr: {}", arr.length);

        // Clone an array
        String[] clonedArr = arr.clone();
        logger.info("Cloned array:");
        for (String element : clonedArr) {
            logger.info("Element: {}", element);
        }

        // Searching for an element
        String searchElement = "Element5";
        boolean found = false;
        for (String element : arr) {
            if (element.equals(searchElement)) {
                found = true;
                break;
            }
        }
        logger.info("Is '{}' found in the array? {}", searchElement, found);
    }
}
