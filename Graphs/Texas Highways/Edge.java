/*
* Instructions:
* 1. Complete the constructor 
* 2. Create getter methods for all instance variables.
*/
public class Edge 
{
    private String name;
    private double weight;
    private Vertex sourceVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex, String name, double weight) 
    {
      sourceVertex = startVertex;
      this.targetVertex = targetVertex;
      this.name = name;
      this.weight = weight;
    }

    public Vertex getSourceVertex()
    {
      return sourceVertex;
    }
  
    public Vertex getTargetVertex()
    {
      return targetVertex;
    }

    public String getName()
    {
      return name;
    }

    public double getWeight()
    {
      return weight;
    }


    @Override // Do not change the equals or toString methods.
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Edge other = (Edge) obj;
        return this.name.equals(other.name) && this.weight == other.weight &&
            this.sourceVertex.getName().equals(other.sourceVertex.getName()) && 
            this.targetVertex.getName().equals(other.targetVertex.getName());
    }
    
    @Override // Do not change the equals or toString methods.
    public String toString() {
        return String.format("%s -> %s: %s, %f",
            this.sourceVertex.getId(), this.targetVertex.getId(), this.name, this.weight);
    }
}