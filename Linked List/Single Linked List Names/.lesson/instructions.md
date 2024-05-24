# Instructions  

Complete the NamesList.java class. 

This class will manage a Singly Linked List of names. See below for a list of methods that you will need to implement. 

You will also need to create a Node class containing a String and next field. (Refer to the previous assignment)


```
/**
 * This method adds the name in the correct alphabetical 
 * order in the linked list
 */
public void add(String name)

/**
 * This method returns the name at the head of the list
 * but does not remove it. Throws NoSuchElementException
 * if the list is empty.
 */
public String getFirst()

/**
 * This method removes and returns the name at the head 
 * of the list. Throws NoSuchElementException if the 
 * list is empty.
 */
public String removeFirst()

/**
 * This method returns true if the list is empty. 
 * Otherwise, it should return false.
 */
public boolean isEmpty()

/**
 * Removes the given string from the list and return 
 * true. Returns false if the name does not exist.
 */
public boolean remove(String name)

/**
 * This method returns true if the list contains the 
 * specified name. Otherwise it returns false.
 */
public boolean contains(String name)

/**
 * The toString method should return a String containing 
 * all of the names in the list in the correct order. For 
 * example.  [Andy, Katie, Nisha, Rohit]
 */
public String toString()

```

  