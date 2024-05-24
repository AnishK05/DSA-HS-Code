import java.util.NoSuchElementException;

public class MyDeque {

    // Use the main method to test and debug your methods

    Node head = null;
    Node tail = null;

    public boolean addEven(int num)
    {
        Node newNode = new Node(num);
      
        if (num % 2 == 1)
        {
          return false;
        }
        else
        {
          if (head == null)
          {
            head = newNode;
            tail = newNode;
          }
          else
          {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
          }

          return true;
        }
    }

    public boolean addOdd(int num) 
    {
        Node newNode = new Node(num);
  
        if (num % 2 == 0)
        {
          return false;
        }
        else
        {
          if (tail == null)
          {
            head = newNode;
            tail = newNode;
          }
          else
          {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
          }

          return true;
        }
    }  

    public int getFirst() 
    {
        if (isEmpty())
        {
          throw new NoSuchElementException();
        }
        return head.num;
    }
  
    public int getLast()
    {
        if (isEmpty())
        {
          throw new NoSuchElementException();
        }
        return tail.num;
    }


    public int removeFirst()
    {
        if (isEmpty())
        {
          throw new NoSuchElementException();
        }
        else if (head == tail)
        {
          int temp = head.num;
          head = null;
          tail = null;
          return temp;
        }
        else
        {
          int temp = head.num;
          head.next.prev = null;
          head = head.next;
          
          return temp;
        }
    }


    public int removeLast()
    {
       if (isEmpty())
       {
         throw new NoSuchElementException();
       }  
       else if (tail == head)
       {
         int temp = tail.num;
         head = null;
         tail = null;
         return temp;
       }
       else
       {
         int temp = tail.num;
         tail.prev.next = null;
         tail = tail.prev;

         return temp;
       }
    }

    public boolean isEmpty()
    {
        if (head == null)
        {
          return true;
        }
        else
        {
          return false;
        }
    }

    public int contains(int num)
    {
      if (num % 2 == 0)
      {
        Node current = head;
        int counter = 1;
        
        while (current != null)
        {
          if (current.num == num)
          {
            return counter;
          }
          current = current.next;
          counter++;
        }
      }

      if (num % 2 == 1)
      {
        Node current = tail;
        int counter = 1;

        while (current != null)
        {
          if (current.num == num)
          {
            return counter;
          }
          current = current.prev;
          counter++;
        }
      } 

      return -1;
    }

    public int remove(int num) 
    { 
      if (head == null)
      {
        return -1;
      }
      
      if (num % 2 == 0)
      {
        Node current = head;
        int counter = 1;

        if (head.num == num)
        {
          removeFirst();
          return 1;
        }

        while (current != null)
        {
          if (current.num == num)
          {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            return counter;
          }
          current = current.next;
          counter++;
        }
      }

      if (num % 2 == 1)
      {  
        Node current = tail;
        int counter = 1;

        if (tail.num == num)
        {
          removeLast();
          return 1;
        }

        while (current != null)
        {
          if (current.num == num)
          {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            return counter;
          }
          current = current.prev;
          counter++;
        }
      } 

      return -1;
    }
  
    public void merge(MyDeque other)
    {
      if (other != null)
      {
        Node current = other.head;
      
        while (current != null)
        {
          if (current.num % 2 == 0)
          {
            addEven(current.num);
          }
          else
          {
            addOdd(current.num);
          }
          current = current.next;
        }  
      }
    }

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
          str += current.num + ", ";
          current = current.next;
        }

        str += current.num + "]";
        return str;
      }
    }

    
    class Node 
    {
      int num;
      Node prev = null;
      Node next = null;

      public Node(int num) 
      {
          this.num = num;
      }

      public String toString() 
      {
          return "" + num;
      }
    }
}