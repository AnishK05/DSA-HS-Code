import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListProblems 
{

    /**
     * Return a list of integers containing the first 3 digits 
     * of pi, {3, 1, 4}.
     *
     * makePi() → [3, 1, 4]
     */
    public static ArrayList<Integer> makePi() 
    {
        ArrayList<Integer> list;
  
        list = new ArrayList<>( Arrays.asList(3, 1, 4) );

        return list;
    }

    /**
     * Given a list of integers, return true if the list is size 1 
     * or more, and the first element and the last element are equal.
     *
     * sameFirstLast([1, 2, 3]) → false 
     * sameFirstLast([1, 2, 3, 1]) → true
     * sameFirstLast([1, 2, 1]) → true
     */
    public static boolean sameFirstLast(ArrayList<Integer> list) 
    {
        if(list.size() > 0 && list.get(0).equals(list.get(list.size()-1)))
        {
          return true;
        }

        return false;
    }

    /**
     * Return the given list where the first and last elements are 
     * swapped with each other. The list size will be at least 1. 
     * Do NOT create a new list!
     *
     * swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1] 
     * swapEnds([1, 2, 3]) → [3, 2, 1]
     * swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
     */
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list) 
    {
      int firstOne = list.get(0);
      int lastOne = list.get(list.size()-1);

      list.set(0, lastOne);
      list.set(list.size()-1, firstOne);

      return list;
    }

    /**
     * Given a list of integers, return a list with the elements 
     * "rotated left" so {1, 2, 3} yields {2, 3, 1}.
     *
     * rotateLeft([1, 2, 3]) → [2, 3, 1] 
     * rotateLeft([5, 11, 9]) → [11, 9, 5]
     * rotateLeft([7, 0, 0]) → [0, 0, 7]
     */
    public static ArrayList<Integer> rotateLeft(ArrayList<Integer> list) 
    {
        list.add(list.get(0));
        list.remove(0);

        return list;
    }

    /**
     * Given a list of integers, return true if it contains a 2 or a 3
     * but not both 2 and 3.
     *
     * has23([2, 5]) → true 
     * has23([4, 3]) → true 
     * has23([1, 7]) → false 
     * has23([2, 3]) → false
     */
    public static boolean has23(ArrayList<Integer> list) 
    {
        if (list.contains(2) && list.contains(3))
        {
          return false;
        }

        else if (list.contains(2) || list.contains(3))
        {
          return true;
        }

        return false;
    }

    /**
     * Return true if the given list of integers contains 2 fours or
     * 2 fives.
     *
     * double45([4, 4]) → true 
     * double45([5, 5]) → true 
     * double45([4, 5]) → false
     */
    public static boolean double45(ArrayList<Integer> list) 
    {
        int count4 = 0;
        int count5 = 0;
      
        for (int i = 0; i < list.size(); i++)
        {
          if(list.get(i) == 4)
          {
            count4++;
          }
        }

        for (int i = 0; i < list.size(); i++)
        {
          if(list.get(i) == 5)
          {
            count5++;
          }
        }
      
        if (count4 > 1 || count5 > 1) 
        {
          return true;
        }

        return false;
    }

    /**
     * In the given list of integers if there is a 2 in the list
     * immediately followed by a 3, set the 3 value to 0. Return 
     * the changed list. Do NOT create a new list!
     *
     * fix23([1, 2, 3]) → [1, 2, 0] 
     * fix23([2, 3, 5]) → [2, 0, 5] 
     * fix23([1, 2, 1]) → [1, 2, 1]
     */
    public static ArrayList<Integer> fix23(ArrayList<Integer> list) 
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
          if (list.get(i) == 2)
          {
            if(list.get(i+1) == 3)
            {
              list.set(i+1, 0);
            }
          }
        }

        return list;
    }

    /**
     * Consider the sum of the values in the two given lists of 
     * integers called a and b. Return the list which has the 
     * largest sum. In event of a tie, return list a. 
     * Do NOT create a new list!
     *
     * biggerTwo([1, 2], [3, 4]) → [3, 4] 
     * biggerTwo([3, 4], [1, 2]) → [3, 4]
     * biggerTwo([1, 4], [3, 2]) → [1, 4]
     */
    public static ArrayList<Integer> biggerTwo(ArrayList<Integer> a, ArrayList<Integer> b) 
    {
        int sumA = 0;
        int sumB = 0;
  
        for(int i = 0; i < a.size(); i++)
        {
          sumA += a.get(i);
        }
        
        for(int i = 0; i < b.size(); i++)
        {
          sumB += b.get(i);
        }

        if (sumA > sumB || sumA == sumB)
        {
          return a;
        }
        else
        {
          return b;
        }
    }

    /**
     * In the given list of integers compare the first, middle 
     * and last value. Return the largest of the three. The 
     * list size will be a least 1.
     *
     * maxTriple([1, 2, 3]) → 3 
     * maxTriple([1, 5, 3]) → 5 
     * maxTriple([5, 2, 3]) → 5
     */
    public static int maxTriple(ArrayList<Integer> list) 
    {
        int start = list.get(0);
        int middle = list.get(list.size() / 2);
        int end = list.get(list.size() - 1);

        if (start >= middle && start >= end)
        {
          return start;
        }
          
        else if (middle >= start && middle >= end)
        {
          return middle;
        }
      
        return end;  
    }

    /**
     * Given lists of integers, a and b, return a new list of 
     * size 3 containing elements from list a followed by list b. 
     * The given lists may be any size, including 0, but there
     * will be 3 or more elements between the 2 lists.
     *
     * make2([4, 5], [1, 2, 3]) → [4, 5, 1] 
     * make2([4], [1, 2, 3]) → [4, 1, 2]
     * make2([], [1, 2, 3]) → [1, 2, 3]
     */
    public static ArrayList<Integer> make3(ArrayList<Integer> a, ArrayList<Integer> b)    
    { 
        ArrayList<Integer> list = new ArrayList<>();

        if (a.size() == 0)
        {
          list.add(b.get(0));
          list.add(b.get(1));
        }
        else if (b.size() == 0)
        {
          list.add(a.get(0));
          list.add(a.get(1));
        }
        else if (a.size() > 1)
        {
          list.add(a.get(0));
          list.add(a.get(1));
        }
        else
        {
          list.add(a.get(0));
          list.add(b.get(0));
        }
      
        return list;  
    }
}
