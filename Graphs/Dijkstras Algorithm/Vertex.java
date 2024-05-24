import java.util.ArrayList;
import java.util.List;

/**
 * Complete the Vertex class. You may want to copy your code from your 
 * previous assignment. Make sure the class implements Comparable.
 */
public class Vertex implements Comparable<Vertex> 
{
    private String name;
    private boolean visited;
    private List<Edge> edgeList;
  
    // shortest path from the source vertex to this vertex
    // should be initialized in the constructor to the 
    // maximum integer value
    private int distance;
  
    // the previous node in the shortest path
    private Vertex previous;
  
    /*
    * Complete the constructor and add getter and setter methods 
    * for all instance variables.
    */
    public Vertex(String name)
    {
      this.name = name;
      visited = false;
      edgeList = new ArrayList<>();
  
      distance = Integer.MAX_VALUE;
  
      previous = null;
    }
  
    public String getName()
    {
      return name;
    }
    public void setName(String name)
    {
      this.name = name;
    }
  
    public boolean isVisited() 
    {
      return visited;
    }
    public void setVisited(boolean visited) 
    {
      this.visited = visited;
    }
  
    public List<Edge> getEdgeList() 
    {
      return edgeList;
    }
    public void addEdge(Edge e)
    {
      edgeList.add(e);
    }
  
    public int getDistance()
    {
      return distance;
    }
    public void setDistance(int distance)
    {
      this.distance = distance;
    }
  
    public Vertex getPrevious()
    {
      return previous;
    }
    public void setPrevious(Vertex previous)
    {
      this.previous = previous;
    }
  
    public int compareTo(Vertex vertex)
    {
      if (this.getDistance() > vertex.getDistance())
      {
        return 1;
      }
      else if (this.getDistance() < vertex.getDistance())
      {
        return -1;
      }
      else
      {
        return 0;
      }
    }
    
    @Override
    public String toString() 
    {
        return name;
    }
}
