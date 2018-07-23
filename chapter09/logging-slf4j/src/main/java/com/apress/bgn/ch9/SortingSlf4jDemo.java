package com.apress.bgn.ch9;

import com.apress.bgn.ch9.algs.IntSorter;
import com.apress.bgn.ch9.algs.MergeSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Class <code>SortingSlf4jDemo</code> is the entry point of this application.<p>
 *
 * @author Iuliana Cosmina
 * since 1.0
 */
public class SortingSlf4jDemo {

    private static final Logger log = LoggerFactory.getLogger(SortingSlf4jDemo.class);

    /**
     * Executes the whole logic of this program.<p>
     * Creates an <code>int[]</code> instance.<p>
     * Creates an {@link MergeSort} instance.<p>
     * Uses the {@link MergeSort#sort(int[], int, int)} to sort the array.
     *
     * @param args program arguments
     */
    public static void main(String... args) {
        if (args.length == 0) {
            log.error("No data to sort!");
            return;
        }
        int[] arr = getInts(args);

        final StringBuilder sb = new StringBuilder("Sorting  an array with merge sort: ");
        Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
        log.debug(sb.toString());


        IntSorter mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);

        final StringBuilder sb2 = new StringBuilder("Sorted: ");
        Arrays.stream(arr).forEach(i -> sb2.append(i).append( " "));
        log.info(sb2.toString());
    }

    /**
     * Transforms a String[] to an int[] array
     * @param args
     * @return an array of integers
     */
    private static int[] getInts(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (String arg : args) {
            try {
                int toInt = Integer.parseInt(arg);
                list.add(toInt);
            } catch (NumberFormatException nfe) {
                log.warn("Element " + arg + " is not an integer and cannot be added to the array!");
            }
        }
        int[] arr = new int[list.size()];
        int j = 0;
        for (Integer elem : list) {
            arr[j++] = elem;
        }
        return arr;
    }
}
