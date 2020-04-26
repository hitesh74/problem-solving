package algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to sum of their lengths.
 * We need to connect the ropes with minimum cost.
 *
 * <pre>
 *
 * Example:-  4, 3, 2, 6
 *  2 + 3 => New Cost = 5, Total Cost = 5, New ropes = 4, 6, 5
 *  4 + 5 => New Cost = 9, Total Cost = 14, New ropes = 6, 9
 *  6 + 9 => New Cost = 15, Total Cost = 29, New ropes = 15
 *
 *  So, The idea is to connect smallest two ropes first and recur for remaining ropes.
 *
 * </pre>
 */
public class ConnectNRopesWithMinCost {

    // Driver code
    public static void main(String args[]) {
        int ropes[] = {4, 3, 2, 6};
        System.out.println("Total cost for connecting ropes is " + minCost(ropes));
    }

    private static int minCost(int[] ropes) {

        int totalCost = 0;

        // Insert all ropes lengths into min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(ropes).forEach(queue::add);

        while (queue.size() > 1) {
            int cost = queue.poll() + queue.poll();
            queue.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }
}
