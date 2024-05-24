public class CircularSinglyLinkedList 
{
    public Node head = null;

    public Node add(int num)
    {
        Node newNode = new Node(num);
        if (head == null)
        {
          head = newNode;
          head.next = head;
        }
        else
        {
          Node current = head;
          while (current.next != head)
          {
            current = current.next;
          }
          current.next = newNode;
          newNode.next = head;
        }
        return newNode;
    }
    
    public boolean remove(int num)
    {
        if (head == null) 
        {
            return false;
        }
        // removal of the last node.
        if (head == head.next && head.data == num) 
        { 
          head = null;
          return true;
        } 
        // removal of the head. Need to find last node that points to head.
        else if (head.data == num) 
        {
          Node current = head;
          while (current.next != head)
          {
            current = current.next;
          }
          head = current.next.next;
          current.next = head;
          return true;
        } 
        //removal of a Node somewhere in the middle.
        else 
        { 
          Node current = head;
          while (current.next != head)
          {
            if (current.next.data == num)
            {
              current.next = current.next.next;
              return true;
            }
            current = current.next;
          }
        }
        return false;
    }

    public boolean hasCycle(Node otherHead)
    {
        if (otherHead == null) 
        {
            return false;
        }

        Node fastCurrent = otherHead;
        Node slowCurrent = otherHead;

        while (fastCurrent != null && slowCurrent != null)
        {
          slowCurrent = slowCurrent.next;
          fastCurrent = fastCurrent.next.next;
          if (fastCurrent == slowCurrent)
          {
            return true;
          }
        }
        return false;
    }

    // complete. You do not need to finish this method.
    public int distanceFromHead(int num)
    {
        if (head == null) 
        {
            return -1;
        }
        
        if (head.data == num)
        {
            return 1;
        } 
        else 
        {
            int distance = 1;
            Node current = head.next;
            while(current != head) 
            {
                distance++;
                if (current.data == num) 
                {
                    return distance;
                }
                current = current.next;
            }
        }
        return -1;
    }

    // complete. You do not need to finish this method.
    public String toString()
    {
        if (head == null) 
        {
            return "[]";
        }
        
        String result = "[";
        Node current = head;
        while(current.next != head) 
        {
            result += current + ", ";
            current = current.next;
        }
        return result + current + "]";
    }
}