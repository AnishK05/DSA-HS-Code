import java.util.NoSuchElementException;

public class NamesList {

    Node head = null;

    /**
     * This method adds the name in the correct alphabetical 
     * order in the linked list
     */
    public void add(String name)
    {
      Node newNode = new Node(name);

      if (isEmpty())
      {
        head = newNode;
      }
      else
      {
        if (name.compareTo(head.data) <= 0)
        {
          newNode.next = head;
          head = newNode;
          return;
        }

        Node current = head;
        while (current.next != null && name.compareTo(current.next.data) > 0)
        {
          current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
      }
    }

    /**
     * This method returns the name at the head of the list
     * but does not remove it. Throws NoSuchElementException
     * if the list is empty.
     */
    public String getFirst()
    {
      if(head == null)
      {
        throw new NoSuchElementException();
      }
      else
      {
        return head.data;
      }
    }

    /**
     * This method removes and returns the name at the head 
     * of the list. Throws NoSuchElementException if the 
     * list is empty.
     */
    public String removeFirst()
    {
      if(head == null)
        {
          throw new NoSuchElementException();
        }
        else
        {
          Node current = head;
          head = head.next;
          return current.data;
        }
      }

      public void clear()
      {
        while(!isEmpty())
        {
          removeFirst();
        }
    }

    /**
     * This method returns true if the list is empty. 
     * Otherwise, it should return false.
     */
    public boolean isEmpty()
    {
      return head == null; 
    }

    /**
     * Removes the given string from the list and return 
     * true. Returns false if the name does not exist.
     */
    public boolean remove(String name)
    {
      if (contains(name) == false)
      {
        return false;
      }
      else
      {
        if (head.data.equals(name))
        {
          removeFirst();
          return true;
        }
        else
        {
          Node current = head;
          while(current.next != null && !current.next.data.equals(name))
          {
            current = current.next;
          }
          current.next = current.next.next;
          return true;
        }
      }
    }

    /**
     * This method returns true if the list contains the 
     * specified name. Otherwise it returns false.
     */
    public boolean contains(String name)
    {
      Node current = head;
      while (current != null)
      {
        if (current.data.equals(name))
        {
          return true;
        }
        current = current.next;
      }
      return false;
    }

    /**
     * The toString method should return a String containing 
     * all of the names in the list in the correct order. For 
     * example.  [Andy, Katie, Nisha, Rohit]
     */
    public String toString()
    {
      String str = "[";
      Node current = head;

      if (isEmpty())
      {
        return "[]";
      }
      else
      {
        while(current.next != null)
        {
          str + current.data + ", ";
          current = current.next;
        }

        str += current.data + "]";
        return str;
      }
    } 
}