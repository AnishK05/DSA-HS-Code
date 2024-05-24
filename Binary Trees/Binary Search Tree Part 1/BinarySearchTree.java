public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Comparable val) {
        root = add(val, root);
    }

    private Node add(Comparable val, Node current) {
        if (current == null) {
            return new Node(val);
        }

        if (val.compareTo(current.data) < 0) {
            current.left = add(val, current.left);
        } else if (val.compareTo(current.data) > 0) {
            current.right = add(val, current.right);
        }
        return current;
    }

    //Contains Method
    public boolean contains(Comparable val)
    {
      return contains(val, root);
    }

    private boolean contains(Comparable val, Node current)
    {
      if (current == null)
      {
        return false;
      }
      else if (val.compareTo(current.data) < 0)
      {
        return contains(val, current.left); //go left
      }
      else if (val.compareTo(current.data) > 0)
      {
        return contains(val, current.right); //go right
      }
      else 
      {
        return true;
      }
    }
  
    // inOrder Method
    public String inOrder()
    {
      String str = inOrder(root);
      return "[" + str.substring(0, str.length() - 2) + "]";
    }
    private String inOrder(Node current)
    {
      if (current == null)
      {
        return "";
      }
      return inOrder(current.left) + current.data + ", " + inOrder(current.right);
    }

    //preOrder Method
    public String preOrder()
    {
      String str = preOrder(root);
      return "[" + str.substring(0, str.length() - 2) + "]";
    }
    private String preOrder(Node current)
    {
      if (current == null)
      {
        return "";
      }
      return current.data + ", " + preOrder(current.left) + preOrder(current.right);
    }

    //postOrder Method
    public String postOrder()
    {
      String str = postOrder(root);
      return "[" + str.substring(0, str.length() - 2) + "]";
    }
    private String postOrder(Node current)
    {
      if (current == null)
      {
        return "";
      }
      return postOrder(current.left) + postOrder(current.right) + current.data + ", ";
    }
    
    // getHeight Method
    public int getHeight() 
    {
      return getNumLevels() - 1;
    }

    // getWidth Method
    public int getWidth()
    {
      return getWidth(root);
    }
  
    private int getWidth(Node current)
    { 
      if (current == null)
      {
        return 0;
      }
      else 
      {
        return getNumLevels(root.left) + 1 + getNumLevels(root.right);
      }
    }

    // getNumLeaves Method
    public int getNumLeaves()
    {
      return getNumLeaves(root);
    }

    private int getNumLeaves(Node current)
    {
      if ((current.left == null) || (current.right == null))
      {
        return 1;
      }
      else
      {
        return getNumLeaves(current.left) + getNumLeaves(current.right);
      }
    }
    
    //getNumLevels Method
    public int getNumLevels()
    {
      return getNumLevels(root);
    }
  
    private int getNumLevels(Node current)
    {
      if (current == null)
      {
        return 0;
      }
      else
      {
        int numLeft = getNumLevels(current.left);
        int numRight = getNumLevels(current.right);

        if (numLeft > numRight)
        {
          return 1 + numLeft;
        }
        else
        {
          return 1 + numRight;
        }
      }
    }

    // size Method
    public int size()
    {
      return size(root);
    }
  
    private int size(Node current)
    {
      if (current == null)
      {
        return 0;
      }
      else
      {
        return size(current.left) + 1 + size(current.right);
      }
    }

    // toString Method
    public String toString()
    {
      return inOrder();
    }
}