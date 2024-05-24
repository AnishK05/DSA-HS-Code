public class Edge 
{

    private Vertex target;
    private int weight;

    /*
     * Complete the constructor and add getter methods. You do not
     * need setter methods for the Edge class.
     */
    public Edge(Vertex target, int weight) 
    {
      this.target = target;
      this.weight = weight;  
    }

    public Vertex getTarget()
    {
      return target;
    }

    public int getWeight()
    {
      return weight;
    }

}