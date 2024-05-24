public class MyDoublyLinkedList {

    // You should only have two instance variables
    Node head = null;
    Node tail = null;

    public void add(String str) 
    {
      if (str == null)
      {
        return;
      }
      
      char[] array = str.toCharArray();

      for (char c: array)
      {
        Node newNode = new Node(c);

        if (head == null)
        {
          head = newNode;
          tail = newNode;
        }
        else if (c <= head.data)
        {
          newNode.next = head;
          head.prev = newNode;
          head = newNode;
        }
        else if (c >= tail.data)
        {
          newNode.prev = tail;
          tail.next = newNode;
          tail = newNode;
        }
        else
        {
          Node current = head;
          while (current.data <= c)
          {
            current = current.next;
          }

          newNode.prev = current.prev;
          newNode.next = current;
          if (current.prev != null)
          {
            current.prev.next = newNode;
          }
          current.prev = newNode;
        }
      }
    }

    public String removeDuplicates() 
    {
      if (head == null)
      {
        return "";
      }
      
      String removed = "";
      Node current = head;

      while (current.next != null)
      {
        if (current.data == current.next.data)
        {
          removed += current.data;
          current.next = current.next.next;
          if (current.next != null) 
          {
              current.next.prev = current;
          }
        }
        else
        {
          current = current.next;
        }
      }
      return removed;
    }

    public boolean contains(String str) 
    {
      char[] array = str.toCharArray();

      for (char c: array)
      {
        Node current = head;
        boolean found = false;
        
        while (current != null)
        {
          if (c == current.data)
          {
            found = true;
            break;
          }
          current = current.next;
        }
        if (!found)
        {
          return false;
        }
      }
      return true;
    }

    public int remove(String str) 
    {
      char[] array = str.toCharArray();
      int counter = 0;

      for (char c: array)
      { 
        Node current = head;
        
        while (current != null)
        {
          if (c == current.data)
          {
            if (head == tail & current == tail)
            {
              head = null;
              tail = null;
            }
            else if (current == head)
            {
              head = current.next;
              if (head != null)
              {
                head.prev = null;
              }
            }
            else if (current == tail)
            {
              tail = current.prev;
              if (tail != null)
              {
                tail.next = null;
              }
            }
            else
            {
              if (current.prev != null)
              {
                current.prev.next = current.next;
              }
              if (current.next != null)
              {
                current.next.prev = current.prev;
              }
            }
            counter++;
            break;
          }
          current = current.next;
        }
      }
      return counter;
    }

    public String toString() 
    {
      String str = "";
      Node current = head;

      while (current != null)
      {
        str += current.data;
        current = current.next;
      }
      
      return str;
    }

    public String toStringTail() 
    {
      String str = "";
      Node current = tail;

      while (current != null)
      {
        str += current.data;
        current = current.prev;
      }

      return str;
    }
    
    class Node 
    {
      Character data;
      Node next = null;
      Node prev = null;

      public Node (Character data) 
      {
          this.data = data;
      }
    }
}