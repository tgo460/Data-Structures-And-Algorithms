# Hashing Data Structure

## 1. Introduction
**Hashing** is a technique used to map data of arbitrary size to fixed-size values. It is primarily used to implement **Hash Tables** (or Hash Maps), which allow for efficient data retrieval, insertion, and deletion.

*   **Goal**: To perform search, insert, and delete operations in **O(1)** (constant time) on average.
*   **Analogy**: Think of a library where books are stored based on a unique code derived from their title. Instead of searching every shelf, you calculate the code and go directly to that location.

---

## 2. Core Components

### 2.1 Hash Table
A data structure that stores key-value pairs. It uses a **Hash Function** to compute an index into an array of buckets or slots, from which the desired value can be found.

### 2.2 Hash Function
A function that converts a given key into a specific index in the hash table.
$$Index = hash(Key) \% TableSize$$

**Properties of a Good Hash Function:**
1.  **Deterministic**: Same key must always produce the same hash.
2.  **Efficient**: Should be fast to compute.
3.  **Uniform Distribution**: Should map keys evenly across the table to minimize collisions.

---

## 3. Collisions
A **Collision** occurs when two different keys hash to the same index.
$$hash(Key_1) == hash(Key_2)$$

Since the table size is finite and keys can be infinite, collisions are inevitable (Pigeonhole Principle). We must handle them efficiently.

---

## 4. Collision Resolution Techniques

### 4.1 Separate Chaining (Open Hashing)
Each bucket in the hash table is independent and points to a data structure (usually a Linked List) that holds all entries hashing to that index.

*   **Structure**: Array of Linked Lists.
*   **Insertion**: Calculate hash -> Go to index -> Add node to the list.
*   **Search**: Calculate hash -> Go to index -> Traverse list to find key.
*   **Pros**: Simple to implement; table never fills up.
*   **Cons**: Cache performance is poor (pointers); extra memory for links.

**Example:**
Table Size = 5. Hash Function = `key % 5`.
Insert: 10, 15, 7
*   `10 % 5 = 0` -> Index 0: [10]
*   `15 % 5 = 0` -> Index 0: [10] -> [15] (Collision!)
*   `7 % 5 = 2`  -> Index 2: [7]

### 4.2 Open Addressing (Closed Hashing)
All elements are stored within the hash table array itself. If a collision occurs, we search for the next available slot.

#### A. Linear Probing
If the calculated index is occupied, check the next index linearly.
*   **Next Index**: $(hash(key) + i) \% TableSize$ for $i = 0, 1, 2...$
*   **Issue**: **Clustering**. Groups of occupied slots build up, increasing search time.

#### B. Quadratic Probing
Instead of checking the next slot, check slots based on a quadratic function.
*   **Next Index**: $(hash(key) + i^2) \% TableSize$
*   **Issue**: Secondary clustering.

#### C. Double Hashing
Use a second hash function to determine the step size if a collision occurs.
*   **Next Index**: $(hash(key) + i \times hash_2(key)) \% TableSize$
*   **Requirement**: $hash_2(key)$ must never return 0.

---

## 5. Performance Analysis

| Operation | Average Case | Worst Case |
| :--- | :--- | :--- |
| **Search** | $O(1)$ | $O(n)$ |
| **Insert** | $O(1)$ | $O(n)$ |
| **Delete** | $O(1)$ | $O(n)$ |

*   **Worst Case**: Occurs when all keys hash to the same index (e.g., a bad hash function), turning the hash table into a Linked List.

### Load Factor ($\alpha$)
A measure of how full the hash table is.
$$\alpha = \frac{\text{Number of Elements}}{\text{Table Size}}$$

*   **Rehashing**: When $\alpha$ exceeds a threshold (e.g., 0.75 in Java), the table size is doubled, and all existing elements are rehashed to new indices. This keeps operations efficient.

---

## 6. Java Implementation Details (`java.util.HashMap`)

*   **Internal Structure**: Array of `Node<K,V>` (Separate Chaining).
*   **Default Capacity**: 16.
*   **Default Load Factor**: 0.75.
*   **Java 8 Improvement**: If a bucket's linked list grows beyond a threshold (8 nodes), it converts the list into a **Red-Black Tree**. This improves worst-case search from $O(n)$ to $O(\log n)$.

---

## 7. Common Interview Questions

1.  **Design a Hash Map**: Implement `put`, `get`, and `remove` methods handling collisions.
2.  **Two Sum**: Find two numbers in an array that add up to a target. (Use a HashMap to store complements).
3.  **Group Anagrams**: Group strings that are anagrams of each other. (Sort string as key or use character count hash).
4.  **Subarray Sum Equals K**: Find total continuous subarrays whose sum equals K. (Use HashMap to store prefix sums).
5.  **Longest Consecutive Sequence**: Find the length of the longest consecutive elements sequence.

## 8. Quick Code Example (Conceptual Java)

```java
import java.util.LinkedList;

public class SimpleHashMap {
    private class Node {
        int key;
        String value;
        public Node(int key, String value) { this.key = key; this.value = value; }
    }

    private LinkedList<Node>[] buckets;
    private int n; // number of nodes
    private int N; // number of buckets

    public SimpleHashMap() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i=0; i<4; i++) this.buckets[i] = new LinkedList<>();
    }

    private int hashFunction(int key) {
        return Math.abs(key) % N;
    }

    public void put(int key, String value) {
        int bi = hashFunction(key); // bucket index
        // Check if key exists and update
        for(Node node : buckets[bi]) {
            if(node.key == key) {
                node.value = value;
                return;
            }
        }
        // Else add new node
        buckets[bi].add(new Node(key, value));
        n++;
    }

    public String get(int key) {
        int bi = hashFunction(key);
        for(Node node : buckets[bi]) {
            if(node.key == key) return node.value;
        }
        return null;
    }
}
```
