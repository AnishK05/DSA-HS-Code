import java.util.*;

public class BinarySearchTree <T extends Comparable <T>> 
{

    private Node<T> root;

    public BinarySearchTree() 
    {
        root = null;
    }

    //add Method
    public void add(T val) 
    {
        root = add(val, root);
    }
    private Node<T> add(T val, Node<T> current) 
    {
        if (current == null) 
        {
            return new Node<T>(val);
        }
        if (val.compareTo(current.data) < 0) 
        {
            current.left = add(val, current.left);
        } 
        else if (val.compareTo(current.data) > 0) 
        {
            current.right = add(val, current.right);
        }
        return current;
    }

    // inOrder Method
    public String inOrder()
    {
      String str = inOrder(root);
      return "[" + str.substring(0, str.length() - 2) + "]";
    }
    private String inOrder(Node<T> current)
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
    private String preOrder(Node<T> current)
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
    private String postOrder(Node<T> current)
    {
      if (current == null)
      {
        return "";
      }
      return postOrder(current.left) + postOrder(current.right) + current.data + ", ";
    }

    // getNumLeaves Method
    public int getNumLeaves()
    {
      return getNumLeaves(root);
    }
    private int getNumLeaves(Node<T> current)
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
    private int getNumLevels(Node<T> current)
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
    private int size(Node<T> current)
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
    private int getWidth(Node<T> current)
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

    // toString Method
    public String toString()
    {
      return inOrder();
    }

    // returns the lowest value according to the classes 
    // natural ordering. Return null if the tree is empty.
    public T getLowest()
    {
      return getLowest(root).data;
    }
    private Node<T> getLowest(Node<T> current)
    {
      if (current.left == null)
      {
        return current;
      }
      else
      {
        return getLowest(current.left);
      }
    }

    // returns the highest value according to the classes
    // natural ordering. Return null if the tree is empty.
    public T getHighest()
    {
      return getHighest(root).data;
    }
    private Node<T> getHighest(Node<T> current)
    {
      if (current.right == null)
      {
        return current;
      }
      else
      {
        return getHighest(current.right);
      }
    }

    // returns true if the left and right side of any 
    // parent node differ by 1 or less. 
    public boolean isBalanced()
    {
      return isBalanced(root);
    }
    private boolean isBalanced(Node<T> current) 
    {
      if (current == null)
      {
        return false;
      }
      if (size(current.left) == size(current.right) && getNumLevels(current.left) == getNumLevels(current.right))
      {
        return true;
      }
      if (size(current.left) == size(current.right) + 1 && getNumLevels(current.left) == getNumLevels(current.right) + 1)
      {
        return true;
      }
      if (size(current.left) + 1 == size(current.right) && getNumLevels(current.left) + 1 == getNumLevels(current.right))
      {
        return true;
      }
      
      return isBalanced(current.left) && isBalanced(current.right);
    }

    // returns a levelOrder representation of the tree. You 
    // will need to use a queue datastructure for this.
    public String levelOrder()
    {
      return levelOrder(root);
    }
    private String levelOrder(Node<T> current)
    {
      String output = "[";
      
      if (current == null)
      {
        return "";
      }
      else
      {
        Queue <Node <T>> queue = new LinkedList<>();
        queue.add(current);
        
        while (!queue.isEmpty())
        {
          current = queue.remove();
          output += current.data;
          output += ", ";
          if (current.left != null)
          {
            queue.add(current.left);
          }
          if (current.right != null)
          {
            queue.add(current.right);
          } 
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
      }
    }

    public String printTree(int maxLevels) 
    {
        return printTree(root, maxLevels);
    }
    public String printTree(Node<T> root, int maxLevels) 
    {

        List<List<String>> allLevels = new ArrayList<>();
        List<Node<T>> currentLevel = new ArrayList<>();
        List<Node<T>> nextLevel = new ArrayList<>();

        currentLevel.add(root);
        int widestNode = 0;

        // build level order list of lists
        boolean hasNextLevel = true;
        while (hasNextLevel && allLevels.size() < maxLevels) {
            List<String> line = new ArrayList<>();

            hasNextLevel = false;
            for (Node<T> current : currentLevel) {
                if (current == null) {
                    line.add(null);
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    line.add(current.toString());
                    if (current.toString().length() > widestNode) {
                        widestNode = current.toString().length();
                    }
                    nextLevel.add(current.left);
                    nextLevel.add(current.right);

                    if (current.left != null || current.right != null) {
                        hasNextLevel = true;
                    }
                }
            }
            allLevels.add(line);
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
        }

        // build result string
        String result = "Binary Search Tree (Maximum of " + maxLevels + " levels shown.\n";

        // Set output line width using the last level, 
        widestNode += (widestNode % 2 == 1) ? 1 : 0;
        int sizeFactor = (allLevels.size() < 6) ? 4 : 2;
        int width = (int)Math.pow(2, allLevels.size() - 1) * (widestNode + sizeFactor);

        for (int i = 0; i < allLevels.size(); i++) {

            List<String> line = allLevels.get(i);
            int half = width / 2 - 1;
            String spaces = String.format("%" + half +"s", "");
            String dashes = String.format("%" + half +"s", "").replace(" ", "-");
            String lineOutput = "";
            String valueOutput = "";

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // add up arrow beneath parent nodes
                    lineOutput += (j % 2 == 1 && (line.get(j - 1) != null || 
                                                  line.get(j) != null)) ? "^" : " ";

                    // add spaces, vertical bars, and lines result string
                    if (line.get(j) == null) {
                        lineOutput += String.format("%" + (width - 1) + "s", "");
                    } else {
                        lineOutput += (j % 2 == 0) ? spaces + "|" + dashes : dashes + "|" + spaces;
                    }
                }
                result += lineOutput.replaceAll("\\s+$", "") + "\n";
            }

            // add node values to the result string
            for (String item : line) {
                int gap = (item == null) ? width / 2 : width / 2 - item.length() / 2;
                valueOutput += String.format("%" + gap +"S%s%" + gap + "S", 
                                             "", (item == null) ? "" : item, "");
            }
            result += valueOutput.replaceAll("\\s+$", "") + "\n";
            width /= 2;
        }
        return result;
    }
}