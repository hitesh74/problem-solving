package algorithm.array.list.recursion;

import java.util.Arrays;

/**
 * Given a list of n-1 sorted integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 */
public class FindMissingIntegerFromConsecutiveList {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(Arrays.toString(arr));
        System.out.println("======================================");
        System.out.println("Missing number: " + search(arr, 0, arr.length));
        System.out.println("Missing number: " + search(arr));
        System.out.println("======================================");

        System.out.println();
        System.out.println();

        int arr2[] = {1, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(arr2));
        System.out.println("======================================");
        System.out.println("Missing number: " + search(arr2, 0, arr2.length));
        System.out.println("Missing number: " + search(arr2));
        System.out.println("======================================");

        System.out.println();
        System.out.println();

        int arr3[] = {1, 2, 3, 5, 6, 7, 8};
        System.out.println(Arrays.toString(arr3));
        System.out.println("======================================");
        System.out.println("Missing number: " + search(arr3, 0, arr3.length));
        System.out.println("Missing number: " + search(arr3));
        System.out.println("======================================");
    }


    private static int search(int arr[]) {
        // Wrong implementation - https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/?ref=rp
        int a = 0, b = arr.length - 1;
        int mid = 0;
        while ((b - a) > 1) {
            mid = (a + b) / 2;
            if ((arr[a] - a) != (arr[mid] - mid))
                b = mid;
            else if ((arr[b] - b) != (arr[mid] - mid))
                a = mid;
        }
        return (arr[mid] + 1);
    }

    private static int search(int[] arr, int start, int end) {

        int mid = (start + end) / 2;
        int expectedNumber = arr[start] + mid - start;


        if (arr[mid - 1] < arr[mid] - 1) {
            return arr[mid] - 1;
        }

        if (arr[mid + 1] > arr[mid] + 1) {
            return arr[mid] + 1;
        }

        if (arr[mid] == expectedNumber) {
            return search(arr, mid, end);
        } else {
            return search(arr, start, mid);
        }
    }
}
