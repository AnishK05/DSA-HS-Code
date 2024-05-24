import java.util.*;

class Main {
    
    public static void main(String[] args) 
    {

        Map<String, Vertex> graph = new HashMap<>();

        graph.put("A", new Vertex("A"));
        graph.put("B", new Vertex("B"));
        graph.put("C", new Vertex("C"));
        graph.put("D", new Vertex("D"));
        graph.put("E", new Vertex("E"));
        graph.put("F", new Vertex("F"));
        graph.put("G", new Vertex("G"));
        graph.put("H", new Vertex("H"));
        graph.put("I", new Vertex("I"));
        graph.put("J", new Vertex("J"));

        /*
         * Add the neighbors for each vertex based on
         * the picture in the instructions. For example,
         */
      
        graph.get("A").addNeighbor(graph.get("B"));
        graph.get("A").addNeighbor(graph.get("C"));
        graph.get("A").addNeighbor(graph.get("F"));
        graph.get("B").addNeighbor(graph.get("D"));
        graph.get("B").addNeighbor(graph.get("E"));
        graph.get("C").addNeighbor(graph.get("H"));
        graph.get("D").addNeighbor(graph.get("G"));
        graph.get("E").addNeighbor(graph.get("H"));
        graph.get("E").addNeighbor(graph.get("G"));
        graph.get("F").addNeighbor(graph.get("H"));
        graph.get("F").addNeighbor(graph.get("J"));
        graph.get("G").addNeighbor(graph.get("I"));
        graph.get("H").addNeighbor(graph.get("J"));
        graph.get("I").addNeighbor(graph.get("J"));
        
        /*
         * Create a Deque that will store the
         * verticies in Topological order
         */
        Deque<Vertex> deque = new LinkedList<>();

        /*
         * Loop through the list of vertex objects in
         * your graph. If you have not visited that
         * vertex then call dfs with that vertex.
         */
        for (Vertex vertex : graph.values())
        {
          if (!vertex.isVisited())
          {
            dfs(vertex, deque);
          }
        }
      
        /*
         * Print Deque to get the Topological order.
         */
        System.out.println(deque);

    }

    /*
     * Perform a depth first search on vertices that have not been
     * visited. Add each Vertex the the front of the deque before
     * you return. Steps:
     * 1. set the current vertex as visited.
     * 2. loop through the neighbors of the current vertex.
     * 3. if the neighbor has not been visited, call dfs on it.
     * 4. add the current vertex to the front of the deque after
     *    the loop ends.
     */
    public static void dfs(Vertex vertex, Deque<Vertex> deque) 
    {
      vertex.setVisited(true);
      
      for (Vertex neighbor : vertex.getNeighborList())
      {
        if (!neighbor.isVisited())
        {
          dfs(neighbor, deque);
        }
      }

      deque.addFirst(vertex);
      
    }
}