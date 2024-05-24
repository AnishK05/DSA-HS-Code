# Instructions  

### In this assignment you will modify and optimize your code from the previous assignment called Texas Highways. The basic Dijkstra's Algorithm assumes we don't have any information related to the location of the ending vertex. However, in a highway map with coordinates we know at any point the direction and direct distance to the ending vertex. Therefore, we can optimize the priority queue with this information by favoring edges and vertices that are closer to the ending vertex while maintaining the shortest path from the starting vertex.


### Review the instance variables, Constructors, and methods for the following classes. 
```Java
 public class Vertex
 public class Edge
 public class Main
 public class DijkstrasAlgorithm
 
 ```

### Complete the follwoing methods or copy them from your previous assignment.

### Main class

    public static Map<Integer, Vertex> getGraph(List<String> data)

### DijkstrasAlgorithm class

    public static void computePath(Vertex start) 
    public static List<Vertex> getPath(Vertex targetVertex)

### Example Output before optimization

    Distance from 5514(TX121@DenTapRd) to 1818(I-35(236)/US290) = 212.277 miles
    Path size = 171
    Poll count = 13,530

### Example Output after optimization

    Distance from 5514(TX121@DenTapRd) to 1818(I-35(236)/US290) = 212.277 miles
    Path size = 171
    Poll count = 1,051

