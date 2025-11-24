import java.util.*;

/*
 * CONNECT N ROPES WITH MINIMUM COST
 * 
 * CONCEPT:
 * Given N ropes of different lengths, connect them into one rope.
 * The cost to connect two ropes = sum of their lengths.
 * Find the minimum cost to connect all ropes.
 * 
 * APPROACH: Greedy with Min-Heap
 * - Always connect the two shortest ropes first
 * - This minimizes the cumulative cost
 * - Use PriorityQueue (min-heap) to efficiently get smallest ropes
 * 
 * VISUALIZATION:
 * Ropes: [2, 3, 3, 4, 6]
 * 
 * Step 1: Connect 2 + 3 = 5, cost = 5
 *         Heap: [3, 4, 5, 6]
 * 
 * Step 2: Connect 3 + 4 = 7, cost = 5 + 7 = 12
 *         Heap: [5, 6, 7]
 * 
 * Step 3: Connect 5 + 6 = 11, cost = 12 + 11 = 23
 *         Heap: [7, 11]
 * 
 * Step 4: Connect 7 + 11 = 18, cost = 23 + 18 = 41
 *         Heap: [18] (final rope)
 * 
 * Total Cost: 41
 * 
 * TIME COMPLEXITY: O(n log n)
 * SPACE COMPLEXITY: O(n)
 */

public class ConnectNRopes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ropes = {2, 3, 3, 4, 6};

        for(int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;

        // Dry Run
        System.out.println("=== DRY RUN ===");
        System.out.println("Initial ropes: " + Arrays.toString(ropes));
        System.out.println();

        int step = 1;
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            int currentCost = min + min2;
            cost += currentCost;

            System.out.println("Step " + step + ": Connect " + min + " + " + min2 + " = " + currentCost);
            System.out.println("        Cost so far: " + cost);
            
            pq.add(currentCost);
            System.out.println("        Heap now: " + pq);
            System.out.println();
            step++;
        }

        System.out.println("=== RESULT ===");
        System.out.println("Minimum Cost of Connecting N Ropes: " + cost);
    }
}