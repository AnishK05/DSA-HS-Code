import java.util.EmptyStackException;

public class MyStack implements MyStackInterface 
{
  int[] array = new int[10];
  int size = 0;
  
  public int size()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return size==0;
  }

  public void push(int num)
  {
    if (size >= array.length)
    {
      int[] temp = new int[array.length*2];
      System.arraycopy(array, 0, temp, 0, size);
      array = temp;
    }
    
    array[size] = num;
    size++;
  }

  public int peek()
  {
    if (size==0)
    {
      throw new EmptyStackException();
    }

    return array[size-1];
  }

  public int pop()
  {
    if (size==0)
    {
      throw new EmptyStackException();
    }

    int popper = array[size-1];
    array[size-1] = 0;
    size--;
    
    return popper;
  }

  public int search(int num)
  {
      for (int i = size-1; i >= 0; i--)
      {
        if(array[i] == num)
        {
          return size-i;
        }
      }

      return -1;
  }

  public int[] toArray()
  {
      int[] returner = new int[size];
    
      for (int i = 0; i < size; i++)
      {
        returner[i] = array[i];
      }
    
      return returner;
  }
  
}