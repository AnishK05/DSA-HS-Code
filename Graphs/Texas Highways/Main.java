import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String verticesFile = "TX-dfw50.vertices.txt";
        String edgesFile = "TX-dfw50.edges.txt";
        Map<Integer, Vertex> graph = getGraph(readFile(verticesFile), readFile(edgesFile));

        Vertex start = graph.get(740); //Coppell (TX121@DenTapRd)
        Vertex end = graph.get(1328);  //Midlothian (US67/US287)

        DijkstrasAlgorithm.computePath(start, end);
        List<Vertex> path = DijkstrasAlgorithm.getPath(end);

        System.out.printf("\nPath from %s to %s = %s\n", start, end, path);
        System.out.printf("\nDistance from %s to %s = %.3f miles\n", start, end, end.getDistance());
        System.out.printf("Path size = %d\n", path.size());
        System.out.printf("Poll count = %,d\n", DijkstrasAlgorithm.pollCount);
    }

    /*
    * Refer to the the assignment instructions for completing the getGraph method
    */
    public static Map<Integer, Vertex> getGraph(List<String> verticesList, List<String> edgesList) 
    {
        Map<Integer, Vertex> map = new HashMap<>();

        for (int i = 0; i < verticesList.size(); i++)
        {
          String[] parts = verticesList.get(i).split(" ");
          
          String sourceName = parts[0];
          double sourceLat = Double.parseDouble(parts[1]);
          double sourceLong = Double.parseDouble(parts[2]);

          Vertex vertex = new Vertex(i, sourceName, sourceLat, sourceLong);
          
          map.put(i, vertex);
        }

        for (int i = 0; i < edgesList.size(); i++)
        {
          String[] parts = edgesList.get(i).split(" ");

          int sourceVertexID = Integer.parseInt(parts[0]);
          int targetVertexID = Integer.parseInt(parts[1]);
          String sourceName = parts[2];

          Vertex sourceVertex = map.get(sourceVertexID);
          Vertex targetVertex = map.get(targetVertexID);

          //Calculate total weight (distance)
          List<Double> coordinates = new ArrayList<>();
          
          coordinates.add(sourceVertex.getLatitude());
          coordinates.add(sourceVertex.getLongitude());

          for (int j = 3; j < parts.length - 1; j=j+2)
          {
            coordinates.add(Double.parseDouble(parts[j]));
            coordinates.add(Double.parseDouble(parts[j+1]));

            // Handles exceptions
            // try {
            //   coordinates.add(Double.parseDouble(parts[j]));
            //   coordinates.add(Double.parseDouble(parts[j+1])); }
            // catch (Exception e) {
            //   System.out.println(parts[0] + " " + parts[1] + " " + parts[2]); }
          }

          coordinates.add(targetVertex.getLatitude());
          coordinates.add(targetVertex.getLongitude());

          double totalDistance = 0.0;
          
          for (int k = 0; k < coordinates.size() - 3; k=k+2)
          {
            double lat1 = coordinates.get(k);
            double long1 = coordinates.get(k+1);
            double lat2 = coordinates.get(k+2);
            double long2 = coordinates.get(k+3);

            totalDistance += calculateDistance(lat1, long1, lat2, long2);
          }
          
          Edge edge1 = new Edge(sourceVertex, targetVertex, sourceName, totalDistance);
          Edge edge2 = new Edge(targetVertex, sourceVertex, sourceName, totalDistance);
          sourceVertex.addEdge(edge1);
          targetVertex.addEdge(edge2);
        }  
      
        return map;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 0.621371192; // convert to miles

        return distance;
    }

    public static void resetGraph(Map<Integer, Vertex> graph) {
        DijkstrasAlgorithm.pollCount = 0;
        for (Vertex v : graph.values()) {
            v.setPrevious(null);
            v.setDistance(Integer.MAX_VALUE);
        }
    }

    public static List<String> readFile(String filename) {
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