import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        String filename = "data.txt";
        Map<String, Vertex> graph = getGraph(readData(filename)); // complete the getGraph method below

        Vertex start = graph.get("A"); // assign your start vertex
        Vertex end = graph.get("G"); // assign your end vertex

        DijkstrasAlgorithm da = new DijkstrasAlgorithm();

        // call computePath in DikstrasAlgorithm class
        da.computePath(start);

        List<Vertex> path = da.getPath(end); // call getPath in DikstrasAlgorithm class
        System.out.println("\nPath from " + start + " to " + end + " = " + path);
        System.out.println("Distance from " + start + " to " + end + " = " + end.getDistance());
    }

    /*
     * The getGraph method should return a Map where the Key is the Vertex name
     * and the value is the Vertex. You will need to create all the vertices then
     * add the edges to each Vertex.
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

    public static List<String> readData(String filename) {
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