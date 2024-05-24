interface SLLStackInterface {

    /**
     * The method places the value at the head of the stack.
     */
    public void addFirst(int value);

    /**
     * The method places the value at the tail of the stack.
     */
    public void addLast(int value);

    /**
     * The method returns the value at the head of the stack but does not remove it.
     * Throws NoSuchElementException if the stack is empty.
     */
    public int getFirst();

    /**
     * The method removes and returns the value at the head of the stack.
     * Throws NoSuchElementException if the stack is empty.
     */
    public int removeFirst();

    /**
     * Empties the stack of all elements
     */
    public void clear();

    /**
     * The method empty returns true if the stack is empty otherwise it should
     * return false.
     */
    public boolean isEmpty();

    /**
     * The method returns true if the stack contains the specified value. Otherwise
     * it it returns false.
     */
    public boolean contains(int value);

    /**
     * The method toArray returns an array containing all of the elements in the
     * stack in the correct order. The head element should be at index 0.
     */
    public int[] toArray();

}
