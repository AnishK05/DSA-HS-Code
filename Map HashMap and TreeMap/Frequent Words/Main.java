import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader("TimeMachine.txt"));
        List<String> list = br.lines().collect(Collectors.toList());
        br.close();

        Map<Integer, List<String>> other = topWords(list, 100);
        for (Integer key : other.keySet()) {
            System.out.println(key + " - " + other.get(key));
        }
    }

    public static Map<Integer, List<String>> topWords(List<String> lines, int num)     
    {
      //Removing formatting and converting to lowercase
      List<String> cleanWords = new ArrayList<>();

      for (String line : lines)
      {
        String[] words = line.replaceAll("[^a-zA-Z-' ]", "").toLowerCase().split("\\s+");
        
        for (String word : words) 
        { 
            if (!word.isEmpty())
            {
              cleanWords.add(word);
            }
        }
      }

      //Getting frequencies of all worlds
      Map<String, Integer> wordFrequencies = new HashMap<>();
      
      for (String word : cleanWords)
      {
        if (wordFrequencies.containsKey(word))
        {
          wordFrequencies.put(word, wordFrequencies.get(word) + 1);
        }
        else
        {
            wordFrequencies.put(word, 1);
        }
      }
      
      //Only looking at frequencies greater than num
      Map<Integer, List<String>> frequenciesByCount = new TreeMap<>();

      for (String word : wordFrequencies.keySet())
      {
        int count = wordFrequencies.get(word);
        
        if (count > num)
        {
          if (frequenciesByCount.containsKey(count))
          {
            frequenciesByCount.get(count).add(word);
          }
          else
          {
            frequenciesByCount.put(count, new ArrayList<>());
            frequenciesByCount.get(count).add(word);
          }
        }
      }
      
      return frequenciesByCount;
    }  
}