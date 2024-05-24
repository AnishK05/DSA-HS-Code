import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TravelingSalesPerson {
    
    private Map<Integer, Vertex> verticeGraph;
    private int pollCount;

    //Add instance variables
    private double minDistance;
    private List<Vertex> shortestPath;
    private Set<Vertex> visitedSet;


    public TravelingSalesPerson(Map<Integer, Vertex> verticeGraph) {
        this.verticeGraph = verticeGraph;
    }

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
    public void findShortestRoute(List<Vertex> vertexStops) 
    {
        minDistance = Integer.MAX_VALUE;
        pollCount = 0;
        shortestPath = new ArrayList<Vertex>();
        visitedSet = new HashSet<Vertex>();

        //looping through vertexStops
        for (Vertex source: vertexStops)
        {
            for (Vertex target: vertexStops)
            {
                if (source != target)
                {
                    source.addVertexStops(target, computePath(source, target));
                }
            }
        }

        //Recursive call
        findShortestRouteRecursive(vertexStops, vertexStops.get(0), 0.0, new ArrayList<Vertex>());
    }

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
    private void findShortestRouteRecursive(List<Vertex> vertexStops, Vertex currentVertex, double currentDistance, List<Vertex> currentPath) 
    {
        //Adding vertex to list
        visitedSet.add(currentVertex);
        currentPath.add(currentVertex);

        //changing distance if equal
        if (currentPath.size() == vertexStops.size())
        {
            currentDistance += currentPath.get(currentPath.size()-1).getVertexStops().get(currentPath.get(0));

            if (currentDistance < minDistance)
            {
                minDistance = currentDistance;
                shortestPath.clear();

                for (Vertex v: currentPath)
                {
                    shortestPath.add(v);
                }
                shortestPath.add(vertexStops.get(0));
            }
        }
        else
        {
            for (Vertex v: vertexStops)
            {
                if (!visitedSet.contains(v))
                {
                    double distance = currentVertex.getVertexStops().get(v);
                    findShortestRouteRecursive(vertexStops, v, currentDistance + distance, currentPath);
                }
            }
        }

        visitedSet.remove(currentVertex);
        currentPath.remove(currentPath.get(currentPath.size() - 1));

    }

    /*
    * Copy your computPath method from the previous assignment
    * Call resetVerticeGraph at the top.
    * 
    * The method has been modified from the previous assignment to 
    * return a double. When you poll end off the PriorityQueue then 
    * return end vertex's distance. Return -1 after the while 
    * loop ends.
    */
    private double computePath(Vertex start, Vertex end) 
    {
        resetVerticeGraph();
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        
        start.setDistance(0);
        queue.add(start);
        
        while (!queue.isEmpty())
        {
            Vertex v = queue.poll();
            pollCount++;

            if (v == end)
            {
                return end.getDistance();
            }

            for (Edge a : v.getEdgeList())
            {
                Vertex target = a.getTargetVertex();
                
                target.setDistanceToEnd(end);
                if (target.getDistance() > (v.getDistance() + a.getWeight()))
                {
                    target.setDistance(v.getDistance() + a.getWeight());
                    target.setPrevious(v);
                    queue.add(target);
                }
            }
        }
        
        return -1;
    }

    private void resetVerticeGraph() {
        for (Vertex v : verticeGraph.values()) {
            v.setDistance(Double.POSITIVE_INFINITY);
            v.setPrevious(null);
        }
    }

    public List<Vertex> getPath(Vertex current) {
        List<Vertex> path = new LinkedList<>();
        while (current != null) {
            path.add(0, current);
            current = current.getPrevious();
        }
        return path;
    }

    public int getPollCount() {
        return pollCount;
    }

    public double getMinimumRouteDistance() {
        return minDistance;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }
}
