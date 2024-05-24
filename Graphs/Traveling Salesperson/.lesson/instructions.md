# Traveling Salesperson Problem
![Bruteforce](Bruteforce.gif)

https://en.wikipedia.org/wiki/Travelling_salesman_problem

The travelling salesperson problem (TSP), asks the following question: "Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city?" It is a problem in combinatorial optimization, important in theoretical computer science and operations research.

TSP can be modeled as an undirected weighted graph, such that cities are the graph's vertices, paths are the graph's edges, and a path's distance is the edge's weight. It is a minimization problem starting and finishing at a specified vertex after having visited each other vertex exactly once.

The most direct solution would be to try all permutations (ordered combinations) and see which one is cheapest (using brute-force search). The running time for this approach lies within a polynomial factor of 𝑂(𝑛!), the factorial of the number of cities, so this solution becomes impractical even for only 20 cities. This does not include the time complexity of Dijkstras Algorithm which is run for every combination of source and target cities.

# Instructions 

Review the main method in the Main class. The getGraph method has been completed for you.

## Vertex class

1. In the Vertex class, add an instance variable (vertexStops) that will store the list of Vertex stops the traveling salesperson will make and their distances. (Hint: Use a Map). 
2. Create getter and setter methods for this instance variable.
## TravelingSalesPerson class
The TravelingSalesPerson constructor has been completed for you.
1. Create the following additional instance variables.
```
double minDistance;        // The minimum distance for the path
List<Vertex> shortestPath; // The order of stops that make up the minimimum distance path
Set<Vertex> visitedSet;    // Keeps track of the stops that have been visited so we only visit them once
```
3. Complete the following methods in the TravelingSalesPerson class. 
```
public void findShortestRoute(List<Vertex> vertexStops) {
 /*
    * Instructions
    * 1. Initialize minDistance to infinity.
    * 2. Initialize pollCount, shortestPath, and visited.
    * 3. Loop through the vertexStops and call the setVertexStops 
    *    method you created in the Vertex class. You should add each 
    *    Vertex to a Map in the Vertex class less its own and get
    *    it's distance to all the other stops using computePath.
    * 4. Call findShortestRouteRecursive and pass it the vertexStops,
    *    the first Vertex in vertexStops, 0 for currentDistance,
    *    and a new ArrayList<>() for currentPath.
    */
}

private void findShortestRouteRecursive(List<Vertex> vertices, Vertex currentVertex, double currentDistance, List<Vertex> currentPath) {
    /*
    * Instructions
    * 1. Add the currentVertex to the visitedSet.
    * 2. Add the currentVertex to the currentPath.
    * 3. If the currentPath size equals the vertexStops.size then,
    *    a. increase currentDistance by the distance between the  
    *       last Vertex in the currentPath and the first 
    *       Vertex in the currentPath.
    *    b. if the currentDistance is less than the minDistance then,
    *       1. set the minDistance to currentDistance.
    *       2. clear the shortestPath.
    *       3. addAll the Vertices from currentPath to shortestPath.
    *       4. Finally add the first Vertex in vertexStops to the 
    *          shortestPath.
    * 3. Else we have not reached the end, so we keep going.
    *    a. Loop through the currentVertex's list of vertexStops .
    *    b. If the stop has not been visited, then get its distance to 
    *       the next Vertex from the loop.
    *    c. call findShortestRouteRecursive .
    * 4. After the Else statement, we have to backtrack.
    *    a. Remove the currentVertex from visitedSet.
    *    b. Remove the last Vertex in currentPath.
    */
}

private double computePath(Vertex start, Vertex end) {
    PriorityQueue<Vertex> queue = new PriorityQueue<>();
    resetVerticeGraph();
    
    /*
    * Copy your computPath method from the previous assignment
    * Call resetVerticeGraph at the top.
    * 
    * The method has been modified from the previous assignment to 
    * return a double. When you poll end off the PriorityQueue then 
    * return end vertex's distance. Return -1 after the while 
    * loop ends.
    */
    
    return -1;
}
```
Given the following stops, the findShortestRoute should visit every Vertex and find the route with the minimum distance starting at the first Vertex and ending back at the first Vertex.
```
stops.add(verticeGraph.get(740));  // Coppell
stops.add(verticeGraph.get(1328)); // Midlothian
stops.add(verticeGraph.get(285));  // Colleyville
stops.add(verticeGraph.get(545));  // Arlington
stops.add(verticeGraph.get(983));  // Highland Park
stops.add(verticeGraph.get(478));  // Downtown Fort Worth
```
Example output:
```
Best tour: [740, 285, 478, 545, 1328, 983, 740]
Path Size: 7
Distance:  117.294
PollCount: 2,482
```
  