import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main 
{

    public static void main(String[] args) 
    {

        String filename = "data.txt";
        List<String> data = readData(filename);
        Map<String, Vertex> graph = getGraph(data);
        /*
         * Complete the main method
         * 1. Set the distance for Vertex A to zero.
         * 2. Create a TopologicalOrdering object
         * 3. Get the Deque of vertices from the TopologicalOrdering object
         * so that you can use it to create a ShortestPath object. You may
         * also want to print out the deque so that you can see what your
         * Topological order looks like.
         * 4. Finally run the ShortestPath compute method
         */

        graph.get("A").setDistance(0);
        TopologicalOrdering topo = new TopologicalOrdering(graph);
        Deque<Vertex> deque = topo.getDeque();
        ShortestPath shortest = new ShortestPath(deque);
        shortest.compute();
        


        

        System.out.println();
        String target = "J";
        System.out.println("Distance from A to " + target + " is " + graph.get(target).getDistance());
        System.out.println("Shortest Path is: " + graph.get(target).getPrevious() + " - " + target);
        System.out.println();
    }

    /*
     * The getGraph method should return a Map where the Key is the Vertex name
     * and the value is the Vertex. You will need to create all the vertices then
     * add the edges to each Vertex. You will need to use Integer.parseInt()
     */
    public static Map<String, Vertex> getGraph(List<String> data) 
    {
       Map<String, Vertex> map = new HashMap<>();

       for (String s : data.get(0).split(" "))
       {
         Vertex vertex = new Vertex(s);
         map.put(s, vertex);
       }
      
       for (int i = 1; i < data.size(); i++)
       {
         String[] parts = data.get(i).split(" ");
         
         String sourceName = parts[0];
         String targetName = parts[1];
         int weight = Integer.parseInt(parts[2]);

         Vertex sourceVertex = map.get(sourceName);
         Vertex targetVertex = map.get(targetName);

         if (sourceVertex != null && targetVertex != null)
         {
           Edge edge = new Edge(targetVertex, weight);
           sourceVertex.addEdge(edge);
         }  
       }
        
        return map;
    }

    public static List<String> readData(String filename) 
    {
        List<String> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                list.add(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Find not found");
        }
        return list;
    }
}
