import java.util.*;

public class DijkstrasAlgorithm {

    // increment pollCount when you poll a Vertex from your priority queue.
    public static int pollCount = 0;

    public static void computePath(Vertex start, Vertex end) 
    { 
      double sDistanceE = Main.calculateDistance(start.getLatitude(), start.getLongitude(), end.getLatitude(), end.getLongitude());
      
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
          target.setEndDistance(end);

          if (target.getDistance() > current.getDistance() + edge.getWeight())
          {
            target.setDistance(current.getDistance() + edge.getWeight());
            target.setPrevious(current);
            pq.remove(target);
            pq.add(target);     
          }
        }
        if (current == end)
        {
          return;
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