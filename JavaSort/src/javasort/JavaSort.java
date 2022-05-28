
package javasort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Joshua Hall 11.19.2021
 */
public class JavaSort {
    public static <T extends Comparable<T>> void sort(
        final T[] array, final boolean ascending)
    {
        Arrays.sort(array, (T o1, T o2) -> (ascending?o1.compareTo(o2):o2.compareTo(o1)));
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a series of numbers separated by spaces to have them sorted:");
        String sArr = scanner.nextLine();
        String[] strArr = sArr.split(" ", 0);
        Integer[] arr = new Integer[strArr.length];
        try {
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter whole numbers please. Exiting program");
            System.exit(0);
        }
        System.out.println("Array:   " + Arrays.asList(arr));
        JavaSort.sort(arr, true);
        System.out.println("Sorted:  " + Arrays.asList(arr));
        JavaSort.sort(arr, false);
        System.out.println("Sorted Decending: " + Arrays.asList(arr));
    }
    
}
