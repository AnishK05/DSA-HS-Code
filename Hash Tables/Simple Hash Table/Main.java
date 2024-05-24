import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(new File("zipcodes.txt"));
        int[] data = new int[input.nextInt()];
        for (int i = 0; i < data.length; i++) {
            data[i] = input.nextInt();
        }

        int size = 50;
        LinkedList<Integer>[] table = getHashTable(data, size);

        double collisions = 0;
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + table[i]);
            collisions += table[i] == null || table[i].isEmpty() ? 0 : table[i].size() - 1;
        }
        System.out.println("\nNumber of collisions = " + collisions);
    }

    public static LinkedList<Integer>[] getHashTable(int[] data, int size) 
    {
      LinkedList<Integer>[] hashTable = new LinkedList[size];

      for (int i = 0; i < hashTable.length; i++)
      {
        hashTable[i] = new LinkedList<>();
      }

      for (int i = 0; i < data.length; i++)
      {
        Integer n = data[i];
        hashTable[n.hashCode() % size].add(n);
      }
      
      return hashTable;
    }
}