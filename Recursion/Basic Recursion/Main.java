class Main {

    public static void main(String[] args) 
    {
        print1to10(10);
        System.out.println(fib(8));
        System.out.println(pi("My favorite pie is apple pie"));
        System.out.println(array10(new int[] { 2, 14, 7, 70, 6, 3 }, 0));
        System.out.println(array10(new int[] { 2, 14, 7, 75, 6, 3 }, 0));
        System.out.println(removeDups("aaabbbcc"));
    }

    /**
     * Print the numbers 1 to 10 recursively
     */
    public static void print1to10(int n) 
    {
      if (n == 0)
      {
        return;
      }
      
      print1to10(n - 1);
      System.out.println(n);
    }

    /**
     * The fibonacci sequence is a famous bit of mathematics, and it 
     * happens to have a recursive definition. The first two values 
     * in the sequence are 0 and 1 (essentially 2 base cases). Each 
     * subsequent value is the sum of the previous two values, so the 
     * whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
     * Define a recursive fib(n) method that returns the nth fibonacci 
     * number, with n=0 representing the start of the sequence.
     */
    public static int fib(int n) 
    {
      if (n < 2)
      {
        return n;
      }

      return fib(n-1) + fib(n-2);
    }

    /**
     * Given a string, compute recursively (no loops) a new string
     * where all appearances of "pi" have been replaced by "3.14".
     */
    public static String pi(String str) 
    {
      if (str.length() < 2)
      {
        return str;
      }
      
      if (str.length() < 3)
      {
        if (str.compareTo("pi") == 0)
        {
          return "3.14";
        }
        else
        {
          return str;
        }
      }
      
      if (str.substring(0,2).compareTo("pi") == 0)
      {
        return "3.14" + pi(str.substring(2));
      }
      else
      {
        return str.substring(0, 1) + pi(str.substring(1));
      }
    }

    /**
     * Given an array of ints, compute recursively if the array 
     * contains somewhere a value followed in the array by that 
     * value times 10. We'll use the convention of considering 
     * only the part of the array that begins at the given index. 
     * In this way, a recursive call can pass index+1 to move 
     * down the array. The initial call will pass in index as 0.
     */
    public static boolean array10(int[] array, int startIdx) 
    {
      if (startIdx >= array.length - 1)
      {
        return false;
      }

      if (array[startIdx+1] == array[startIdx] * 10)
      {
        return true;
      }
      
      return array10(array, startIdx + 1);
    }

    /**
     * Given a string, return recursively a string where adjacent 
     * chars that are the  same have been reduced to a single 
     * char. For example, removeDups("aabbbc") returns "abc.
     */
    public static String removeDups(String str) 
    {
      if (str.length() < 2)
      {
        return str;
      }
      
      if (str.substring(0,1).equals(str.substring(1, 2)))
      {
        return removeDups(str.substring(1));
      }

      return str.substring(0, 1) + removeDups(str.substring(1));
    }
}