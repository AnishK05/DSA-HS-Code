# Instructions  

### Copy the following methods from Binary Search Tree Part 1.
```
public void add(T value)
private Node<T> add(T value, Node<T> current)

public String inOrder()
private String inOrder(Node<T> current)

public String preOrder()
private String preOrder(Node<T> current)

public String postOrder()
private String postOrder(Node<T> current)

public int getNumLeaves() 
private int getNumLeaves(Node<T> current)

public int getNumLevels()
private int getNumLevels(Node<T> current)

public int size()
private int size(Node<T> current)

public int getHeight()

public int getWidth()
```

In this assignment, you will add the following methods. Each method has a private helper method that you need to implement. You are also given a method that will return a String that prints out the tree in a nice visual format.
  
```
// returns the lowest value according to the classes 
// natural ordering. Return null if the tree is empty.
public T getLowest()
private Node getLowest(Node<T> current)

// returns the highest value according to the classes
// natural ordering. Return null if the tree is empty.
public T getHighest()
private Node getHighest(Node<T> current)

// returns true if the left and right side of any 
// parent node differ by 1 or less. 
public boolean isBalanced()
private boolean isBalanced(Node<T> current) 

// returns a levelOrder representation of the tree. You 
// will need to use a queue datastructure for this.
public String levelOrder()
private String levelOrder(Node<T> current)
```

Example output:
```
In order     [10, 15, 20, 25, 35, 40, 45, 55, 60, 70, 75, 80]
Pre order    [60, 25, 15, 10, 20, 40, 35, 55, 45, 80, 70, 75]
Post order   [10, 20, 15, 35, 45, 55, 40, 25, 75, 70, 80, 60]
Level Order  [60, 25, 80, 15, 40, 70, 10, 20, 35, 55, 75, 45]
Width        8
Levels       5
Lowest       10
Highest      80
isBalanced   false

Binary Search Tree (Maximum of 5 levels shown.
                                               60
                        |-----------------------^-----------------------|
                       25                                              80
            |-----------^-----------|                       |-----------^
           15                      40                      70
      |-----^-----|           |-----^-----|                 ^-----|
     10          20          35          55                      75
                                       |--^
                                      45

  ```
