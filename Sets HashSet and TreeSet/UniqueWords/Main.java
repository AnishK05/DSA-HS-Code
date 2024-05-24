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

class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String str = "The one 2 Pick is the last one!!";
        System.out.println(str +"\nUnique words: " + uniqueWords(Arrays.asList(str)) + "\n");
        str = "I 'don't know' I dont know I owe $5.75";
        System.out.println(str +"\nUnique words: " + uniqueWords(Arrays.asList(str)) + "\n");
        str = "s; dP5 389m    j7zs;45 bz0 s.x4Dp";
        System.out.println(str +"\nUnique words: " + uniqueWords(Arrays.asList(str)) + "\n");
      
        String file = "TimeMachine.txt";
        BufferedReader reader = new BufferedReader(new FileReader("TimeMachine.txt"));
        List<String> list = reader.lines().collect(Collectors.toList());
        reader.close();

        System.out.println("\n" + file.replace(".txt", ""));
        System.out.println("Unique words: " + uniqueWords(list));
    }

    /**
    * uniqueWords will receie a list of strings where each 
    * string in the list is a line of text. Loop through
    * lines one at a time and "clean" the the line according 
    * to the instructions. Then split the line and add each 
    * word to a HashSet. 
    * Return the size of the HashSet.
    */
    public static int uniqueWords(List<String> lines) 
    {
        Set<String> hash = new HashSet<>();

        for (int i = 0; i < lines.size(); i++)
        {
          String line = lines.get(i).toLowerCase();
          
          String cleanLine = "";

          for (int j = 0; j < line.length(); j++)
          {
            char ch = line.charAt(j);
            int ascii = (int) ch;
            
            if ( (ascii >= 97 && ascii <= 122) )
            {
              cleanLine += ch;
            }
            else if (ascii == 39)
            {
              if (j==0 || j==line.length() - 1)
              {
                cleanLine += " ";
              }
              else
              {
                char ch1 = line.charAt(j-1);
                char ch2 = line.charAt(j+1);

                int ascii1 = (int) ch1;
                int ascii2 = (int) ch2;

                if ( (ascii1 >= 97 && ascii1 <= 122) && (ascii2 >= 97 && ascii2 <= 122) )
                {
                  cleanLine += ch;
                }
                else
                {
                  cleanLine += " ";
                }
              }
            }
            else if (ascii == 45)
            {
              if (j==0 || j==line.length() - 1)
              {
                cleanLine += " ";
              }
              else
              {
                char ch3 = line.charAt(j-1);
                char ch4 = line.charAt(j+1);

                int ascii3 = (int) ch3;
                int ascii4 = (int) ch4;

                if ( (ascii3 >= 97 && ascii3 <= 122) && (ascii4 >= 97 && ascii4 <= 122) )
                {
                  cleanLine += ch;
                }
                else
                {
                  cleanLine += " ";
                }
              }            
            }
            else
            {
              cleanLine += " ";
            }
          }
            
          String[] splitted = cleanLine.split(" ");
          
          for (String k : splitted)
          {
            if(!k.isEmpty())
            {
              hash.add(k);
            }
          }
        }
      
        return hash.size();
    }   
}