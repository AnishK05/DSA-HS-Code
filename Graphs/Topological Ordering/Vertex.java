import java.util.*;

public class Vertex 
{

    private String name;
    private boolean visited;
    private List<Vertex> neighborList;

    /*
    * Complete the constructor by
    * initializing the instance variables
    */
    public Vertex(String name) 
    {
      this.name = name;
      visited = false;
      neighborList = new ArrayList<>();
    }

    /*
     * Returns visited
     */
    public boolean isVisited() 
    {
      return visited;
    }

    /*
     * Sets visited to the given value
     */
    public void setVisited(boolean visited) 
    {
      this.visited = visited;
    }

    /*
     * Adds the given Vertex object to neighborList 
     */
    public void addNeighbor(Vertex vertex) 
    {
      neighborList.add(vertex);
    }

    /*
     * Returns the neighborList List
     */
    public List<Vertex> getNeighborList() 
    {
      return neighborList;
    }

    /*
     * Returns the vertex name
     */
    public String toString() 
    {
      return name;
    }
}