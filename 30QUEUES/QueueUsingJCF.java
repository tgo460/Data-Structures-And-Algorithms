// Queue Linked List Using Java Collection Frame Work

public class QueueUsingJCF {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public Queue() {}

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
    public void add(int data) {
        // Add 1st Element
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove
    public int remove() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }

        int front = head.data;
        if(head == tail) {
            tail = head = null;
        } else {
            head = head.next;
        }
        size--;
        return front;
    }

    // peek 
    public int peek() {
        if(isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return head.data;
    }


    public int size() {
        return size;
    }

    }

    public static void main(String[] args) {
        // Queue q = new Queue();

        Queue<Integer> q = new LinkedList<>();

        q.add(1);    
        q.add(2);    
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}