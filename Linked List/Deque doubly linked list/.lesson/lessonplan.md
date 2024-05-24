# Lesson plan
  
126.35. Computer Science III TEKS 
(c) (3)  Research and information fluency. The student locates, analyzes, processes, and organizes data. The student is expected to: 
  
## Learning Objectives
  1. (D)  understand and trace a linked-list data structure; 
  2. (E)  create program solutions using a linked-list data structure, including unordered single, ordered single, double, and circular linked; 
  3. (F)  understand composite data structures, including a linked list of linked lists; 
  
  ### Estimated time to complete: 1-2 class periods

  ## Notes
  1. Show visual representation of Double Linked List vs Single
  2. Go over the Node class and point out Node prev
  3. Remind the about edge cases / exceptions at the head and tail
  5. Demo writing the first method addFirst


```java
public boolean addFirst(int num) {
    if (num % 2 != 0) {
        return false;
    }
    Node n = new Node(num);

    if (head == null) {
        head = n;
        tail = n;
    } else {
        n.next = head;
        head.prev = n;
        head = n;
    }
    return true;
}
```

  