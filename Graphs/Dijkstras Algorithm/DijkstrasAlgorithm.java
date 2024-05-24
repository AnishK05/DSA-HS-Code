import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm 
{
    /**
     * Given the start vertex find the minimum distance to each vertex. 
     * The method should set the distance and previous fields for each
     * vertex visited. You will need to implement a PriorityQueue.
     */
    public static void computePath(Vertex start) 
    {
      PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
      start.setDistance(0);
      pq.add(start);

      while (!pq.isEmpty())
      {
        Vertex current = pq.poll();
        
        for (Edge edge : current.getEdgeList())
        {
          Vertex target = edge.getTarget();

          if (target.getDistance() > current.getDistance() + edge.getWeight())
          {
            pq.add(target);
            target.setDistance(current.getDistance() + edge.getWeight());
            target.setPrevious(current);
          }
        }
      } 
    }

    /**
     * Given the ending vertex, return a List of vertices that make up the
     * shortest path by getting each vertex's previous vertex. Make sure the 
     * list returned is ordered from the starting vertex to the ending vertex.
     */
    public static List<Vertex> getPath(Vertex end) 
    {
      Vertex vertex = end;
      
      List<Vertex> list = new ArrayList<Vertex>();
      
      while (vertex != null)
      {
        list.add(0, vertex);
        vertex = vertex.getPrevious();
      }
      return list;        
    }
}