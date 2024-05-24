import java.util.Map;
import java.util.TreeMap;

class Main 
{
  public static void main(String[] args) 
  {

        String data = "";
        for (int i = 0; i < 250; i++) 
        {
            data += (char) ((int) (Math.random() * 26) + 97);
        }
        System.out.println();
        System.out.println("               1         2");
        System.out.println("char 123455678901234567890");
        System.out.println(createHistogram(data));
    }

    public static String createHistogram(String data) 
    {
      Map <String, String> map = new TreeMap<>();
    
      for (String key : data.split("")) 
      {
        if (map.containsKey(key)) 
        {
          String value = map.get(key);
          value += "*";
          map.put(key, value);
        } 
        else 
        {
            map.put(key, "*");
        }
      }
      //Output Formatting
      String returner = "";

      for (String key : map.keySet())
      {
        returner += (key + "    " + map.get(key) + "\n");
      }

      return returner;
    }
}