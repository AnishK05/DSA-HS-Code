import java.util.*;

public class TopologicalOrdering 
{
    private Deque<Vertex> deque;

    /*
     * The code in the method is very similar to the code
     * in the TopologicalOrdering assignment.
     *
     * Instiantiate the Deque
     * Loop through the vertices (values) in the graph map.
     * if the vertex has not been visited then call dfs with
     * that vertex.
     */
    public TopologicalOrdering(Map<String, Vertex> graph) 
    {
        deque = new LinkedList<>();

        for (Vertex vertex : graph.values())
        {
          if (!vertex.isVisited())
          {
            dfs(vertex);
          }
        }
    }

    /*
     * This method is almost identical to the dfs method from the
     * Topological Ordering assignment except that you will loop
     * through the given vertes's edges and getting the vertex
     * associated with that edge.
     */
    private void dfs(Vertex vertex) 
    {
      vertex.setVisited(true);

      for (Edge edge : vertex.getEdgeList())
      {
        if (!edge.getTarget().isVisited())
        {
          dfs(edge.getTarget());
        }
      }

      deque.addFirst(vertex);
    }

    public Deque<Vertex> getDeque() 
    {
        return this.deque;
    }
}