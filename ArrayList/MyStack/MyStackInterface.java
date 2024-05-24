public interface MyStackInterface {

    /**
     * The method size should return the size of the 
     * stack not the size of the hidden array.
     */
    public int size();

    /**
     * The method empty returns true if the stack
     * is empty otherwise it should return false.
     */
    public boolean isEmpty();

    /**
     * The method push places the given integer on 
     * top of the stack.
     */
    public void push(int num);

    /**
     * The method peek returns the int that is on top 
     * of the stack but does not remove it. Throws 
     * EmptyStackException if the stack is empty.
     */
    public int peek();

    /**
     * The method pop removes and returns the int that 
     * is on top of the stack. Throws EmptyStackException 
     * if the stack is empty.
     */
    public int pop();

    /**
     * The method search returns the distance from the top 
     * of the stack of the occurrence nearest the top of 
     * the stack; the topmost item on the stack is 
     * considered to be at distance 1. The return value -1 
     * indicates that the number is not on the stack. For
     * example, if the stack contains {5, 3, 7, 5, 1} 
     * where 1 is the top of the stack and search(5) is
     * called then the method will should return 2.
     */
    public int search(int num);

    /**
     * The method toArray returns an array containing all of 
     * the elements in the stack in the correct order. The 
     * first element pushed to the stack should be at index 0;
     */
    public int[] toArray();

}