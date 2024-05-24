import java.util.*;

public class DijkstrasAlgorithm {

    // increment pollCount when you poll a Vertex from your priority queue.
    public static int pollCount = 0;

    public static void computePath(Vertex start, Vertex end) 
    {
      PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
      start.setDistance(0);
      pq.add(start);

      while (!pq.isEmpty())
      {
        Vertex current = pq.poll();
        pollCount++;

        for (Edge edge : current.getEdgeList())
        {
          Vertex target = edge.getTargetVertex();

          if (target.getDistance() > current.getDistance() + edge.getWeight())
          {
            target.setDistance(current.getDistance() + edge.getWeight());
            target.setPrevious(current);
            // pq.remove(target);
            pq.add(target);
          }
        }
      } 
    }
  
    public static List<Vertex> getPath(Vertex current) 
    {
      Vertex vertex = current;

      List<Vertex> list = new ArrayList<Vertex>();

      while (vertex != null)
      {
        list.add(0, vertex);
        vertex = vertex.getPrevious();
      }
      return list;
    }
}