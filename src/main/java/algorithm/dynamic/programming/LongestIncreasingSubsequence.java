package algorithm.dynamic.programming;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent/problem
 *
 * <p>
 * The task is to find the length of the longest subsequence in a given array of integers such that all elements of the subsequence are sorted in strictly ascending order. This is called the Longest Increasing Subsequence (LIS) problem.
 * <p>
 *
 * <pre>
 *   Example: 15, 27, 14, 38, 26, 55, 46, 65, 85
 *
 *   Ans is 6 (15, 27, 38, 55, 65, 85)
 *
 * </pre>
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of lis is " + longestIncrSubSeq(arr) + "\n");
    }

    // Complete the longestIncreasingSubsequence function below.
    // Its O(n * n)
    // For O(N LogN) see https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //
    private static int longestIncrSubSeq(int[] arr) {
        int[] lis = new int[arr.length];

        // LIS for all elements is at least 1
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }

        int answer = lis[0];

        // LIS at ith element is Max(LIS at j where j = 0 to i-1 and arr[i] > arr[j])
        for (int i = 1; i < lis.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
            answer = Math.max(answer, lis[i]);
        }

        return answer;
    }
}
