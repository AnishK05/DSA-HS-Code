import java.util.*;

public class ShortestPath 
{
    private Deque<Vertex> deque;

    // initialize all instance variable(s)
    public ShortestPath(Deque<Vertex> deque) 
    {
        this.deque = deque;
    }

    /*
     * The compute method should pop a vertex off Deque and loop through
     * its edges getting each edge's target vertex. if the target's distance is
     * greater than the current vertex's distance plus the edge weight then set
     * the target's distance to the current distance plus the edge weight. Then
     * set the target's pervious vertex to the current vertex.
     *
     * Repeat until the Deque is empty
     */
    public void compute() 
    {
      while (!deque.isEmpty())
      {
        Vertex current = deque.pop();
        
        for (Edge edge : current.getEdgeList())
        {
          Vertex target = edge.getTarget();

          if (target.getDistance() > current.getDistance() + edge.getWeight())
          {
            target.setDistance(current.getDistance() + edge.getWeight());
            target.setPrevious(current);
          }
        }
      }      
    }
}