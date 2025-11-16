public class LinkedList {
    public static class Node {
        // 
        int data;
        Node next;

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        
    }

    public Node head;
    public Node tail;
    public int size;

    // Methods for add delete print and etc

    public void addFirst(int data) {

        // Step 1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // Step 2 = newNode next = head
        newNode.next = head; // link

        // step 3 = head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        // Special Case
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev: i = size - 2
        Node prev = head;
        for(int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Search in the Linked List

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found
        return -1;
    }

    public int recSearch(int key) {
        return recSearchHelper(head, key, 0);
    }

    private int recSearchHelper(Node temp, int key, int index) {
        // Base Case
        if(temp == null) {
            return -1;
        }

        // Check current Node
        if(temp.data == key) {
            return index;
        }

        return recSearchHelper(temp.next, key, index + 1);
    }

    // Reverse Linked list
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and Remove Nth node from End

    public void deleteNthfromEnd(int n) {
        // Calculate size

        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next; // removeFirst
            return;
        }

        // sz - n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // Check if LL is a palindrome

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my midNode
    }


    public boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        // step1 - find
        Node midNode = findMid(head);

        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        // step3 - check half & right half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public boolean isCycle() {
        if(head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast) {
                return true; // Cycle exists
            }
        }

        return false; // Cycle doesn't exists
    }

    public void removeCycle() {
        if(head == null) {
            return;
        }
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;

    }

    // Zig-Zag Linked List
    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alt merge  - zig-zag merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public static void main(String args[]) {
        // Create a LinkedList instance
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        // 1->2->3->4->5->6->null

        ll.print();
        ll.zigZag();
        ll.print();


        // ll.head = new Node(1);
        // Node temp = new Node(2);
        // ll.head.next = temp;
        // ll.head.next.next = new Node(3);
        // ll.head.next.next.next = temp;

        // //1->2->3->1
        // System.out.println(ll.isCycle());

        // ll.removeCycle();
        // System.out.println(ll.isCycle());
        
        // Object
        // LinkedList ll = new LinkedList();

        // ll.addFirst(2);
        // // ll.print();
        // ll.addFirst(1);
        // // ll.print();
        // ll.addLast(4);
        // // ll.print();
        // ll.addLast(5);
        // // ll.print();
        // ll.add(2, 3);


        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // // ll.addLast(1);

        // System.out.println(ll.checkPalindrome());

        // ll.print();
        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.size);


        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // ll.reverse();
        // ll.print();

        // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();
    }
}