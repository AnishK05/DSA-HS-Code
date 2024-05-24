// Do not import or use the ArrayList class

public class MyArrayList implements MyArrayListInterface 
{

    private String[] list = new String[10];
    private int size = 0;
    
    public String[] getPrivateArray()
    {
      return list;
    }

    public void add(String str)
    {
      if (size >= list.length)
      {
        String[] temp = new String[list.length*2];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
      }
      
      list[size] = str;
      size++;
    }

    public void add(int idx, String str)
    {
        if (idx < 0 || idx > size)
        {
          throw new IndexOutOfBoundsException();
        }

        if (size >= list.length)
        {
          String[] temp = new String[list.length*2];
          System.arraycopy(list, 0, temp, 0, size);
          list = temp;
        }

        String[] temp1 = new String[list.length];
        System.arraycopy(list, 0, temp1, 0, idx);
        temp1[idx] = str;
        System.arraycopy(list, idx, temp1, idx+1, list.length-idx-1);

        list = temp1;
        size++;
    }

    public void addAll(MyArrayList items)
    {
      String[] otherArray = items.toArray();
      int numItems = size + otherArray.length;

      while(list.length < numItems)
      {
        String[] temp = new String[list.length * 2];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
      }

      System.arraycopy(otherArray, 0, list, size, otherArray.length);
      size += otherArray.length; 
    }
    
    public int size()
    {
      return size;
    }
    
    public boolean isEmpty()
    {
      return size==0;
    }
    
    public String get(int idx)
    {
      if (idx < 0 || idx >= size)
      {
        throw new IndexOutOfBoundsException();
      }
      
      return list[idx];
    }
    
    public String set(int idx, String str)
    {
      if (idx < 0 || idx >= size)
      {
        throw new IndexOutOfBoundsException();
      }
      
      String temp = list[idx];
      list[idx] = str;
      return temp;
    }
    
    public String remove(int idx)
    {
      if (idx < 0 || idx >= size)
      {
        throw new IndexOutOfBoundsException();
      }
      
      String element = list[idx];
        
      String[] temp = new String[list.length];
      System.arraycopy(list, 0, temp, 0, idx);
      System.arraycopy(list, idx+1, temp, idx, list.length - idx-1);
      list = temp;
      
      size--;
      return element; 
    }
  
    public boolean remove(String str)
    {
      int idx = indexOf(str);

      if (idx > -1 && idx < size)
      {
        remove(idx);
        return true;
      }
      else
      {
        return false;
      }
    }
    
    public int indexOf(String str)
    {
        for (int i = 0; i < size; i++)
        {
          if (list[i].equals(str))
          {
            return i;
          }
        }
      
        return -1;
    }
    
    public boolean contains(String str)
    {
      int idx = indexOf(str);

      if (idx > -1 && idx < size)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    
    public MyArrayList subList(int fromIndex, int toIndex)
    {
      if (fromIndex < 0 || fromIndex >= toIndex || toIndex > size)
      {
        throw new IndexOutOfBoundsException();
      }

      MyArrayList newList = new MyArrayList();
      
      for (int i = fromIndex; i < toIndex; i++)
      {
        newList.add(list[i]);
      }

      return newList;
    }
  
    public String[] toArray()
    {
      String[] newArray = new String[size];
      System.arraycopy(list, 0, newArray, 0, size);
      return newArray;
    }
    
    public void trimToSize()
    {
      String[] newArray = new String[size];
      System.arraycopy(list, 0, newArray, 0, size);
      list = newArray;
    }
  
    public String toString()
    {
      String array = "[";
      array += list[0];
      
      for (int i=1; i < size; i++)
      {
        array+= ", ";
        array+= list[i];
      }

      return array + "]";
    }  
}