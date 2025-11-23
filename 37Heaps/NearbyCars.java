import java.util.*;

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

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for(int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println("C" + p.idx + "(" + p.x + ", " + p.y + " )");
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