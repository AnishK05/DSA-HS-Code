public class TriageList {

    Node head = null;

    
    public void addPatient(String name, int priority)
    {
      Node newNode = new Node(name, priority);

      if (head == null)
      {
        head = newNode;
      }
      else
      {
        if (newNode.priority < head.priority)
        {
          newNode.next = head;
          head = newNode;
          return;
        }
        
        Node current = head;
        while (current.next != null && newNode.priority >= current.next.priority)
        {
          current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
      }
    }

    public String treatNextPatient()
    {
      if(head == null)
      {
        return "No patients";
      }
      else
      {
        Node current = head;
        head = head.next;
        return current.name;
      }
    }

    public int contains(String name)
    {
      Node current = head;
      while (current != null)
      {
        if (current.name.equals(name))
        {
          return current.priority;
        }
        current = current.next;
      }
      return -1;
    }
  
    public String triageCount() 
    {
      Node current = head;
      int ones = 0;
      int twos = 0;
      int threes = 0;

      while (current != null)
      {
        if (current.priority == 1)
        {
          ones++;
        }
        else if (current.priority == 2)
        {
          twos++;
        }
        else
        {
          threes++;
        }
        if (current.next == null)
        {
          break;
        }
        current = current.next;
      }
      return  "P1:" + ones + ", " + "P2:" + twos + ", "+ "P3:" + threes;
    }

    public String toString(){
        String result = "[";
        Node current = head;
        while (current != null) {
            result += current;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        return result + "]";
    }

    class Node {

        String name;
        int priority;
        Node next = null;

        public Node(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String toString() {
            return priority + "-" + name;
        }
    }

}