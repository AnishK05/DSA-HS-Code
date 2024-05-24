public class HashTable 
{
    // instance Variables
    int[] hashTable = new int[9];
    
    public boolean add(char c) 
    {
      if (c == '.')
      {
        return true;
      }
      
      int idx = Integer.parseInt(String.valueOf(c));
      
      if (hashTable[idx-1] != 0)
      {
        return false;
      }
      
      hashTable[idx-1] = idx;
      return true;
      
    }  
}