import java.util.*;

public class DeleteInHeap {
    static class Heap {
        private final ArrayList<Integer> arr = new ArrayList<>(); // min-heap

        public void add(int data) {
            arr.add(data);
            int idx = arr.size() - 1;
            int parent = (idx - 1) / 2;
            while (idx > 0 && arr.get(idx) < arr.get(parent)) {
                swap(idx, parent);
                idx = parent;
                parent = (idx - 1) / 2;
            }
        }

        public int peek() {
            if (arr.isEmpty()) throw new NoSuchElementException();
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }

        public int remove() { // remove min
            if (arr.isEmpty()) throw new NoSuchElementException();
            int root = arr.get(0);
            int last = arr.remove(arr.size() - 1);
            if (!arr.isEmpty()) {
                arr.set(0, last);
                heapifyDown(0);
            }
            return root;
        }

        private void heapifyDown(int idx) {
            int size = arr.size();
            while (true) {
                int left = 2 * idx + 1;
                int right = 2 * idx + 2;
                int smallest = idx;
                if (left < size && arr.get(left) < arr.get(smallest)) smallest = left;
                if (right < size && arr.get(right) < arr.get(smallest)) smallest = right;
                if (smallest == idx) break;
                swap(idx, smallest);
                idx = smallest;
            }
        }

        private void swap(int i, int j) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        int[] nums = {5, 3, 8, 1, 4, 2};
        for (int n : nums) h.add(n);
        System.out.println("Peek: " + h.peek());
        while (!h.isEmpty()) {
            System.out.print(h.remove() + " ");
        }
        System.out.println();
    } 
}