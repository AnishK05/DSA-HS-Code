import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Arrays;

public class SetOperations 
{

    private Set<String> setA;
    private Set<String> setB;

    /**
     * Initialize the two set instance variables to
     * TreeSets. Add elements from String A to setA
     * and elements from String B to setB
     * 
     * @param A String elements to be added to setA
     * @param B String elements to be added to setB
     */
    public SetOperations(String A, String B) 
    {
      setA = new TreeSet<>();
      setB = new TreeSet<>();

      String [] lettersA = A.split(" ");
      String [] lettersB = B.split(" ");

      for (String s : lettersA)
      {
        setA.add(s);
      }
      for (String s : lettersB)
      {
        setB.add(s);
      }   
    }

    public Set<String> getSetA() 
    {
        return setA;
    }

    public Set<String> getSetB() 
    {
        return setB;
    }

    /**
     * Union
     * 
     * @return Set containing all elements from both sets
     */
    public Set<String> union() 
    {
      Set<String> setU = new TreeSet<>();

      for (String s : setA)
      {
        setU.add(s);
      }
      for (String s : setB)
      {
        setU.add(s);
      }

      return setU;
    }

    /**
     * Intersection
     * 
     * @return Set containing elements that
     *         appear in BOTH sets
     */
    public Set<String> intersection() 
    {
      Set<String> setI = new TreeSet<>();

      for (String s : setA)
      {
        if (setB.contains(s))
        {
          setI.add(s);
        }
      }
    
      return setI;
    }

    /**
     * Symmetric Difference
     * 
     * @return Set containing elements that
     *         appear in either but not in both
     */
    public Set<String> symmetricDiff() 
    {
      Set<String> setD = new TreeSet<>();

      for (String s : setA)
      {
        if (!setB.contains(s))
        {
          setD.add(s);
        }
      }

      for (String s : setB)
      {
        if (!setA.contains(s))
        {
          setD.add(s);
        }
      }
      return setD;
    }

    /**
     * Difference setA - setB
     * 
     * @return Set containing elements that
     *         appear in setA but not in setB
     */
    public Set<String> diffAMinusB() 
    {
      Set<String> setAB = new TreeSet<>();

      for (String s : setA)
      {
        if (!setB.contains(s))
        {
          setAB.add(s);
        }
      }
      return setAB;      
    }

    /**
     * Difference setB - setA
     * 
     * @return Set containing elements that
     *         appear in setB but not in setA
     */
    public Set<String> diffBMinusA() 
    {
      Set<String> setBA = new TreeSet<>();

      for (String s : setB)
      {
        if (!setA.contains(s))
        {
          setBA.add(s);
        }
      }

      return setBA;  
    }
}
