import java.util.ArrayList;
import java.util.List;

public class Vertex 
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

    @Override
    public String toString() 
    {
        if (previous == null) 
        {
            return "" + name;
        } 
        else 
        {
            return "" + previous + " - " + name;
        }
    }
}
