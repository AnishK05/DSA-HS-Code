import java.util.NoSuchElementException;

class SingleLinkedListStack implements SLLStackInterface {

    Node head = null; // This should be your only instance variable.

    public void addFirst(int value)
    {
      Node newNode = new Node(value);
      newNode.next = head;
      head = newNode;
    }

    public void addLast(int value)
    {
      Node newNode = new Node(value);
      
      if(head == null)
      {
        head = newNode;
      }
      else
      {
        Node current = head;
        while(current.next != null)
        {
          current = current.next;
        }
        current.next = newNode;
      }
    }

    public int getFirst()
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

    public int removeFirst()
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

    public boolean isEmpty()
    {
      return head == null;  
    }

    public boolean contains(int value)
    {
      Node current = head;
      while (current != null)
      {
        if (current.data == value)
        {
          return true;
        }
        current = current.next;
      }
      return false;
    }

    public int[] toArray()
    {
      int counter = 0;
      Node current = head;

      while(current != null)
      {
        counter++;
        current = current.next;
      }

      current = head;
      int[] array = new int[counter];

      for (int i = 0; i < counter; i++)
      {
        array[i] = current.data;
        current = current.next;
      }

      return array;
    }
}