# Traveling Salesperson Problem
  
The travelling salesperson problem (TSP), asks the following question: "Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city?" It is a problem in combinatorial optimization, important in theoretical computer science and operations research.

Complete the TravelingSalesPerson class.


Gven the following stops, the findShortestRoute should visit every Vertex and find the route with the minimum distance starting at the first Vertex and ending back at the first Vertex.
```
stops.add(verticeGraph.get(740));  // Coppell
stops.add(verticeGraph.get(1328)); // Midlothian
stops.add(verticeGraph.get(285));  // Colleyville
stops.add(verticeGraph.get(255));  // Roanoke
stops.add(verticeGraph.get(983));  // Highland Park
stops.add(verticeGraph.get(478));  // Downtown Fort Worth
```
Example output:
```
Best tour: [740, 983, 1328, 478, 285, 255, 740]
Distance:  127.73786079851513
PollCount: 39376
```

  