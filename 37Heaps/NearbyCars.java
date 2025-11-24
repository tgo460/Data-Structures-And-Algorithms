import java.util.*;

/*
 * K NEAREST CARS TO ORIGIN
 * 
 * CONCEPT:
 * Given N cars with (x, y) coordinates, find K nearest cars to origin (0, 0).
 * Distance from origin = √(x² + y²)
 * We use distance² to avoid expensive sqrt calculation
 * 
 * APPROACH: Min-Heap (PriorityQueue)
 * - Calculate distance² for each car
 * - Store cars in min-heap ordered by distance
 * - Extract K smallest elements
 * 
 * VISUALIZATION:
 * Cars: C0(3,3), C1(5,-1), C2(-2,4)
 * 
 * Distance² calculations:
 * C0: 3² + 3² = 18
 * C1: 5² + (-1)² = 26
 * C2: (-2)² + 4² = 20
 * 
 * Min-Heap (ordered by distance²):
 *        C0(18)
 *       /      \
 *    C2(20)   C1(26)
 * 
 * Extract k=2 nearest:
 * 1. Remove C0 → distance² = 18
 * 2. Remove C2 → distance² = 20
 * 
 * Result: C0(3, 3), C2(-2, 4)
 * 
 * TIME COMPLEXITY: O(n log n)
 * SPACE COMPLEXITY: O(n)
 */

public class NearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }
    
    
    public static void main(String[] args) {
        int[][] pts = {
            {3, 3}, {5, -1}, {-2, 4}
        };
        int k = 2;

        // Dry Run
        System.out.println("=== DRY RUN ===");
        System.out.println("Cars and their distances² from origin (0, 0):");
        
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            System.out.println("C" + i + "(" + pts[i][0] + ", " + pts[i][1] + ") → distance² = " + 
                             pts[i][0] + "² + " + pts[i][1] + "² = " + distSq);
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        System.out.println("\n=== RESULT ===");
        System.out.println("K = " + k + " nearest cars:");
        for(int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println("C" + p.idx + " (" + p.x + ", " + p.y + ") with distance² = " + p.distSq);
        }
        
        // nearbyCars(pts, k);
    }
}

/*
static class Car implements Comparable<Car> {
        int x, y;
        int distSq;
        int idx;
        
        public Car(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.distSq = x * x + y * y;
        }
        
        @Override
        public int compareTo(Car c2) {
            return c2.distSq - this.distSq; // Max heap (descending order)
        }
    }
    
    public static void nearbyCars(int[][] pts, int k) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for(int i = 0; i < pts.length; i++) {
            pq.add(new Car(pts[i][0], pts[i][1], i));
        }
        
        // Print k nearest cars
        System.out.println("K nearest cars:");
        for(int i = 0; i < k; i++) {
            Car c = pq.remove();
            System.out.println("C" + c.idx + " (" + c.x + ", " + c.y + ")");
        }
    }
*/