# Instructions  

### Copy the methods from your BinarySearchTree class from previous assignment

In this assignment, you will add a method to rebalance your tree. You will need two helper methods to help accomplish this. 
  
```
/**
 * Rewrite your public and private inorder methods 
 * so they use an ArrayList.
 */
 public String inOrder() {
    List<Node<T> list = new ArrayList<>();
    inOrder(list, root);
    return list.toString();
 }
 
/**
 * Overloaded inOrder helper method. Given a list, this 
 methods adds nodes to that list inOrder. The method works 
 * like the method in your previous assignments except 
 * it adds each Node to a list instead of a String.
 */
private void inOrder(List<Node<T> list, Node<T> current) {

}
  
/**
 * This is the public method that a user will call to rebalance 
 * your binary search tree. You will need to create an inorder
 * list that stores the nodes in your tree.
 * 1. Call the private inOrder method to get an in order list.
 * 2. Call reBuildTree and pass it the list followed by the
 *    starting and ending index of the list. The Node returned
 *    will be the new Root of your balanced tree.
 */
public void reBalanceTree() {

}

/**
 * Recursively rebuild a new Tree from the nodes in the given 
 * inorder list. Given an inorder list of Nodes, implement
 * a binary search over the given list except you will
 * not be searching for a value. You will be traversing the 
 * entire list using a binary search.
 * Steps:
 * 1. return null when leftIdx > rightIdx
 * 2. get the midPoint by (leftIdx + rightIdx + 1) / 2
 * 3. Create a Node current and assign it the Node at the midpoint in the list
 * 4. Assign current.left to the returned Node of reBuildTree(list, leftIdx, midPoint - 1)
 * 5. Assign current.right to the returned Node of reBuildTree(list, midPoint + 1, rightIdx)
 * 6. Return the current Node
 */
private Node<T> reBuildTree(List<Node<T>> list, int leftIdx, int rightIdx) {

}
```

Example output:
```
In order     [10, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100]
Pre order    [50, 30, 10, 20, 25, 40, 100, 90, 80, 70, 60]
Level Order  [50, 30, 100, 10, 40, 90, 20, 80, 25, 70, 60]
Width        10
Levels       6
isBalanced   false
Binary Search Tree (Maximum of 5 levels shown.
                                               50
                        |-----------------------^-----------------------|
                       30                                              100
            |-----------^-----------|                       |-----------^
           10                      40                      90
            ^-----|                                   |-----^
                 20                                  80
                  ^--|                             |--^
                    25                            70


Rebalanced Tree
In order     [10, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100]
Pre order    [50, 25, 20, 10, 40, 30, 80, 70, 60, 100, 90]
Level Order  [50, 25, 80, 20, 40, 70, 100, 10, 30, 60, 90]
Binary Search Tree (Maximum of 5 levels shown.
                               50
                |---------------^---------------|
               25                              80
        |-------^-------|               |-------^-------|
       20              40              70              100
    |---^           |---^           |---^           |---^
   10              30              60              90
  ```


  