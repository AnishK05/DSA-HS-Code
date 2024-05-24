import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.*;

public class Vertex implements Comparable<Vertex> {

    private final int id;
    private final String name;
    private final double latitude;
    private final double longitude;
    private final List<Edge> edgeList;
    private double distance;
    private double distToEnd;
    private Vertex previous;

    //instantiate new instance variable
    private Map<Vertex, Double> vertexStops;

    public Vertex(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.edgeList = new ArrayList<>();
        this.distance = Double.POSITIVE_INFINITY;
        this.distToEnd = 0;  

        //initialize variable
        this.vertexStops = new HashMap<Vertex, Double>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Edge edge) {
        this.edgeList.add(edge);
    }

    public void setDistanceToEnd(Vertex end) {
        distToEnd = Main.calculateDistance(this.latitude, this.longitude, end.latitude, end.longitude);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    //Getter + Setter for vertexStops
    public Map<Vertex, Double> getVertexStops()
    {
        return vertexStops;
    }

    public void addVertexStops(Vertex v, Double d)
    {
        this.vertexStops.put(v, d);
    }

    @Override
    public int compareTo(Vertex other) {
        if (this.distance + this.distToEnd < other.distance + other.distToEnd) {
            return -1;
        } else if (this.distance + this.distToEnd > other.distance + other.distToEnd) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (this.id != other.id || !
            this.name.equals(other.name) || 
            this.edgeList.size() != other.edgeList.size()) {
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            if(!this.edgeList.get(i).equals(other.edgeList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id ;
    }
}
