package algorithm.array.list.recursion;

import java.util.Arrays;

/**
 * You are given an unordered array of unique integers incrementing from .
 * You can swap any two elements a limited number of times. Determine the largest lexicographical
 * value array that can be created by executing no more than the limited number of swaps.
 *
 * <pre>
 *
 * Example: 1, 2, 3, 4
 *
 * Permutations with max swap 1 are
 *        2, 1, 3, 4
 *        3, 2, 1, 4
 *        4, 2, 3, 1
 *
 *  here max (including original is 4, 3, 2, 1)
 *
 *
 * </pre>
 */
public class LargestPermutation {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        int k = 1;
        System.out.println(Arrays.toString(largestPermutation(k, arr)));
    }

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {

        int n = arr.length;

        int where[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            where[arr[i]] = i;
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (arr[i] == n - i) {
                continue;
            } else {
                int val1 = arr[i];
                int pos1 = i;
                int val2 = n - i;
                int pos2 = where[n - i];
                swap(arr, pos1, pos2);
                where[val1] = pos2;
                where[val2] = pos1;
                k--;
            }
        }
        return arr;
    }

    public static void swap(final int[] arr, final int pos1, final int pos2) {
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
