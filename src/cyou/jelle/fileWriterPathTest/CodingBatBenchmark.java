package cyou.jelle.fileWriterPathTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CodingBatBenchmark {
    /**
     * Solutions for https://codingbat.com/prob/p139150
     * 
     * Start with two arrays of strings, A and B, each with its elements in
     * alphabetical order and without duplicates. Return a new array containing the
     * first N elements from the two arrays. The result array should be in
     * alphabetical order and without duplicates. A and B will both have a length
     * which is N or more. The best "linear" solution makes a single pass over A and
     * B, taking advantage of the fact that they are in alphabetical order, copying
     * elements directly to the new array.
     * 
     * 
     * mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
     * mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
     * mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     */
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        mergeTwoSpeedTest(new String[] { "a", "b", "c", "d", "z" }, new String[] { "a", "c", "e", "y", "z" }, 6);
    }

    public static void mergeTwoSpeedTest(String[] a, String[] b, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            mergeTwoUsingHelpers(a, b, n);
        }

        long end = System.currentTimeMillis();

        System.out.println("Using helpers took " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            mergeTwo(a, b, n);
        }
        end = System.currentTimeMillis();

        System.out.println("Without helpers took " + (end - start));

    }

    private static String[] mergeTwoUsingHelpers(String[] a, String[] b, int n) {
        // First implementation using helpers to do the actual work
        HashSet<String> set = new HashSet<String>();

        set.addAll(Arrays.asList(a));
        set.addAll(Arrays.asList(b));

        List<String> list = new ArrayList<String>(set);
        Collections.sort(list);
        String[] sortedArray = new String[list.size()];
        list.toArray(sortedArray);

        return Arrays.copyOf(sortedArray, n);
    }

    private static String[] mergeTwo(String[] a, String[] b, int n) {
        // Second implementation more in line with expected answer.
        // Thought of this myself, but this looks like a special case of
        // (the merge step of) merge sorting with de-duplication perhaps?

        int indexA = 0;
        int indexB = 0;
        int mergedListIndex = 0;

        String[] mergedList = new String[n];

        while (mergedListIndex < n) {
            // comparing chars is typically safer than comparing strings
            char left = a[indexA].charAt(0);
            char right = b[indexB].charAt(0);

            if (left == right) {
                mergedList[mergedListIndex] = a[indexA];
                indexA++;
                indexB++;
            } else if (left < right) {
                mergedList[mergedListIndex] = a[indexA];
                indexA++;
            } else {
                mergedList[mergedListIndex] = b[indexB];
                indexB++;
            }

            mergedListIndex++;
        }

        return mergedList;
    }
}
