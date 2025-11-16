# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.next = None

# class LinkedList:
#     def __init__(self):
#         self.head = None
#         self.tail = None


#     def insert_at_beginning(self, data):
#         new_node = Node(data)
#         if self.head:
#             new_node.next = self.head
#             self.head = new_node
#         else:
#             self.head = new_node
#             self.tail = new_node
    
#     def insert_at_end(self, data):
#         new_node = Node(data)
#         if self.head:
#             self.tail.next = new_node
#             self.tail = new_node
#         else:
#             self.head = new_node
#             self.tail = new_node



    
#     def print_List(self):
#         current = self.head
#         while current:
#             print(current.data)
#             current = current.next

#     def size(self):
#         current = self.head
#         count = 0
#         while current:
#             count += 1
#             current = current.next
#         return count

# ll = LinkedList()
# ll.insert_at_beginning(1)
# ll.insert_at_beginning(2)
# ll.insert_at_end(3)
# ll.insert_at_end(4)

# print("Linked List:")
# ll.print_List()

# print("Size of Linked List:", ll.size())




class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.node_count = 0

    def insert_at_beginning(self, data):
        new_node = Node(data)
        if self.head:
            new_node.next = self.head
            self.head = new_node

        else:
            self.head = new_node
            self.tail = new_node
        self.node_count += 1

    def insert_at_end(self, data):
        new_node = Node(data)
        if self.head:
            self.tail.next = new_node
            self.tail = new_node

        else:
            self.head = new_node
            self.tail = new_node
        self.node_count += 1

        
    def print_list(self):
        current = self.head
        while current:
            print(current.data)
            current = current.next


    def size(self):
        return self.node_count


ll = LinkedList()
ll.insert_at_beginning(1)
ll.insert_at_beginning(2)
ll.insert_at_end(3)

print("Linked List:")
ll.print_list()

print("Size of Linked List:", ll.size())


# Tuples and List
tuples = (1, 2, 3, 4, 5, 6, 7, 7)

tuples.__add__((8, 9, 10))

print(tuples)


list1 = [1, 2, 3, 4, 5, 6, 7, 7]

list1.__add__([8, 9, 10])

print(list1)



Set = set([1, 2, 3, 4, 5, 6, 7, 7])

Set.add(8)

print(Set)