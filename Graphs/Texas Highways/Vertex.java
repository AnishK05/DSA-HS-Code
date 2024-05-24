import java.util.*;

/*
* Instructions:
* 1. Complete the constructor 
* 2. Set distance to Integer.MAX_VALUE and previous to null.
* 3. Create getter methods for all instance variables.
* 4. Create setter methods for setPrevious and setDistance. 
* 5. You will also need an addEdge method that will add a 
*    given edge to the edgeList.
* 6. Implement the interface Comparable using distance for
*    the compareTo method.
*/
public class Vertex implements Comparable<Vertex> 
{

    private int id;           // Vertex ID which is also it's key in your Map
    private String name;      // Friendly name to identify the location
    private double latitude;   
    private double longitude;
    private List<Edge> edgeList;
    private double distance;  // distance from the starting vertex (source)
    private Vertex previous;  // the previous vertex on the shortest path

    public Vertex(int id, String name, double latitude, double longitude) 
    {
      this.id = id;
      this.name = name;
      this.latitude = latitude;
      this.longitude = longitude;
      edgeList = new ArrayList<>();

      distance = Integer.MAX_VALUE;
      previous = null;
    }

    public int getId()
    {
      return id;
    }

    public String getName()
    {
      return name;
    }

    public double getLatitude()
    {
      return latitude;
    }

    public double getLongitude()
    {
      return longitude;
    }

    public List<Edge> getEdgeList() 
    {
      return edgeList;
    }
  
    public void addEdge(Edge e)
    {
      edgeList.add(e);
    }

    public double getDistance()
    {
      return distance;
    }
  
    public void setDistance(double distance)
    {
      this.distance = distance;
    }

    public Vertex getPrevious()
    {
      return previous;
    }
  
    public void setPrevious (Vertex previous)
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
  

    @Override // Do not change the equals or toString methods.
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (this.id != other.id || !
            this.name.equals(other.name) || 
            this.edgeList.size() != other.edgeList.size()) {
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            if(!this.edgeList.get(i).equals(other.edgeList.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override // Do not change the equals or toString methods.
    public String toString() {
        return id + "(" + name + ")";
    }
}