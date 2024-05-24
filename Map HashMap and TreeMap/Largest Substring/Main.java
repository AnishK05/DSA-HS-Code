import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

class Main 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {

        String example = "abcdabcdef";
        System.out.println("\nExample String: " + example);
        System.out.println("Slow: " + slowFindSubstring(example));
        System.out.println("Fast: " + fastFindSubstring(example));
        System.out.println("");

        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line = br.readLine();
        br.close();

        long startTime, estimatedTime1, estimatedTime2;
        String result1, result2;
        System.out.printf("Performance results with a %,d character string.\n", line.length());

        startTime = System.nanoTime();
        result1 = slowFindSubstring(line);
        estimatedTime1 = System.nanoTime() - startTime;
        System.out.printf("Slow: %s\tTime: %10d nanoseconds\n", result1, estimatedTime1);

        startTime = System.nanoTime();
        result2 = fastFindSubstring(line);
        estimatedTime2 = System.nanoTime() - startTime;
        System.out.printf("Fast: %s\tTime: %10d nanoseconds\n", result2, estimatedTime2);
        System.out.printf("\nFast method is %,d times faster.\n", estimatedTime1 / estimatedTime2);
    }

    /**
     * Code the follwoing method with a time complexity of O(n).
     */
    public static String fastFindSubstring(String str) 
    {
      Map<Character, Integer> map = new HashMap<>();
      
      int start = 0;
      int end = 0;
      String longest = "";

      for (end = 0; end < str.length(); end++)
      {
        char current = str.charAt(end);
        
        if (map.containsKey(current) && map.get(current) >= start)
        {
          start = map.get(current) + 1;
        }

        map.put(current, end);

        if (end - start + 1 > longest.length())
        {
          longest = str.substring(start, end + 1);
        }
      }
      return longest;
    }

    public static String slowFindSubstring(String str) 
    {
        String largest = "";

        for (int i = 0; i < str.length(); i++) 
        {
            for (int j = i + 1; j <= str.length(); j++) 
            {
                String subStr = str.substring(i, j);
                boolean[] array = new boolean[256];
                boolean noDuplicates = true;
              
                for (char c : subStr.toCharArray()) 
                {
                    if (array[c] == true) 
                    {
                        noDuplicates = false;
                    } 
                    else 
                    {
                        array[c] = true;
                    }
                }
                if (noDuplicates && subStr.length() > largest.length()) 
                {
                    largest = subStr;
                }
            } 
        }
        return largest;
    }
}