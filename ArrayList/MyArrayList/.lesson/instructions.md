# Instructions  

You will create your own ArrayList class called MyArrayList. Your MyArrayList class will implement the interface called MyArrayListInterface. When a class implements an interface it means that the class must implement (code) all the methods listed in the interface.

    Code your methods in the MyArrayList class not the MyArrayListInterface.

    *** Do not import or use the ArrayList class. ***

The MyArrayList class should implement a private (hidden) String array. Your array should start out with a size of 10 and grow by doubling each time it needs to grow. You may create additional private helper methods and/or instance variables to help you out.

Use the Main class to test your MyArrayList class. 



```
public interface MyArrayListInterface {

    /**
     * Returns the private String array. The String array should 
     * be a private instance variable but the test cases need 
     * access to it so please return it.
     */
     public String[] getPrivateArray();

    /**
     * Appends the given String to the end of this list.
     */
    public void add(String str);

    /**
     * Inserts the given String at the specified position 
     * in this list. Throws IndexOutOfBoundsException if the 
     * index is out of range.
     */
    public void add(int idx, String str);

    /**
    * Appends all of the elements in items to the end of this list.
    * Throws NullPointerException if the given MyArrayList is null.
    */
    public void addAll(MyArrayList items);

    /**
     * Returns the number of elements in this list.
     */
    public int size();

    /**
     * Returns true if this list contains no elements otherwise it
     * returns false.
     */
    public boolean isEmpty();
    
    /**
     * Returns the element at the specified position in this list.
     * Throws IndexOutOfBoundsException if the index is out of range.
     */
    public String get(int idx);

    /**
     * Replaces the element at the specified position in the list
     * with the given String. Returns the element previously at the 
     * specified position. Throws IndexOutOfBoundsException if the 
     * index is out of range.
     */
    public String set(int idx, String str);

    /**
     * Removes the element at the specified position in this list. 
     * Shifts any subsequent elements to the left. Returns the element 
     * that was removed from the list. Throws IndexOutOfBoundsException 
     * if the index is out of range.
     */
    public String remove(int idx);

    /**
     * Removes the first occurrence of the specified element from this 
     * list and returns true if it is present. False is returned if the
     * list does not contain the specified element.
     */
    public boolean remove(String str);

    /**
     * Returns the index of the first occurrence of the specified 
     * String in this list, or -1 if this list does not contain 
     * the element.
     */
    public int indexOf(String str);

    /**
     * Returns true if this list contains the specified String
     * otherwise it returns false.
     */
    public boolean contains(String str);

    /**
    * Returns a new MyArrayList that contains a portion of this 
    * list between the specified fromIndex, inclusive, and toIndex, 
    * exclusive. Throws IndexOutOfBoundsException if the 
    * either index is out of range.
    */
    public MyArrayList subList(int fromIndex, int toIndex);
    
    /**
     * Returns an array containing all of the elements in this 
     * list in proper sequence (from first to last element). The 
     * returned array will be "safe" in that no references to it
     * are maintained by this list. (In other words, this method
     * must allocate a new array). The caller is thus free to 
     * modify the returned array.
     */
    public String[] toArray();

    /**
    * Trims the capacity of this instance array to be the list's 
    * current size.
    */
    public void trimToSize();

    /**
    * Returns a String containing all the elements in the list
    * seperated by a comma and a space. The string return is 
    * enclosed in square brackets. For example,
    * [abc, def, ghi]
    */
    public String toString();

}
```