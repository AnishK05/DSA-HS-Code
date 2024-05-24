# Instructions  

This lab is designed to teach you more about Binary Trees.

Write a BinarySearchTree class. For the base lab, you must write the following methods. 
  
```
public boolean contains(Comparable val)

// The following three methods should include commas and square brackets
// For example, [1, 3, 5, 7, 9]
public String inOrder()
public String preOrder()
public String postOrder()

// returns the number of levels in the tree minus one
public int getHeight() 

public int getWidth()

// returns the number of leave nodes
public int getNumLeaves()

public int getNumLevels()

// return the number of nodes in the tree
public int size()

// returns a String containing an inOrder represention of the tree.
public String toString() 
```
Output should look like.
```
IN ORDER         [70, 80, 85, 90, 98, 100, 120]
PRE ORDER        [90, 80, 70, 85, 100, 98, 120]
POST ORDER       [70, 85, 80, 98, 120, 100, 90]

Contains 80      true
Contains 30      false

Tree size        7
Tree height      2
Tree width       5

Number of leaves 4
Number of levels 3
Tree as a string [70, 80, 85, 90, 98, 100, 120]
```

  