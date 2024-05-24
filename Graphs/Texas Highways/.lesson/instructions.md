# Instructions  

### In this assignment you will use Dijkstra's Algorithm on real world data. We will apply Dijkstra's Algorithm to DFW highway data to find the shortest path between two vertices.

### Complete the following classes. 
```Java
 public class Vertex
 public class Edge
 public class Main
 public class DijkstrasAlgorithm
 ```

### Main.getGraph() method
Real world data is often in a challenging format for our needs. You need to import into your map Vertex and Edge data from two different lists (verticesList and edgesList). verticesList is a list of Strings from the file TX-dfw50.vertices.txt. edgesList contains a list of String from the file TX-dfw50.edges.txt.

verticesList - Assign each vertex an Integer key starting with 0 and incrementing by 1 for each vertex in the list. 
```
For example, the first line in TX-dfw50.vertices.txt is,
US81/US287@FM51_S 33.227874 -97.593264

key/id    = 0  // the next line will have a key/id of 1, etc..
name      = "US81/US287@FM51_S"
latitude  = 33.227874
longitude = -97.593264
```
edgesList - Each string in edgesList will contain a bidirectional edge that contains at least 3 values: source vertex id, target vertex id, and edge name. Some entries will contain additional latitude and longitude coordinates because highways are not always straight lines. If there is a significant bend(s) in the highway then the entry for that edge  will have one or more additional pairs of latitude and longitude coordinates.

You will need to calculate the edge weight by using the Main.caculateDistance() method. This method will return the distance in miles between two sets of latitude and longitude coordinates. If an edge has additional stops (pairs of latitude and longitude coordinates) then you will need to also use those coordinates in addition to the source and target coordinates to find the edge weight.
```
For example, the first line in TX-region.edges.txt is,
47 0 US81,US287

Source Vertex id = 47
Target Vertex id = 0
name = "US81,US287"
weight = // Use the caculateDistance method with the source and target vertex's latitude and longitude coordinates. 
```
Note: Each edge is bidirectional so you will need to create a second edge going in the other direction (just swap the source and target vertices).

### Example Output
```
Path from 740(TX121@DenTapRd) to 1328(US67/US287) = [740(TX121@DenTapRd), 747(TX121_S/TX121BusLew_S), 743(TX121@LakPkwy), 746(TX121@SanLakeRd), 256(TX26@TX121/2499&TX121@TX26/2499), 299(TX121@BassProDr), 277(I-635(36)/TX121), 280(IntPkwy/TX114_E/TX121_N), 278(IntPkwy@AirDr_N), 279(IntPkwy@ExpNor), 281(IntPkwy@TerA/B), 282(IntPkwy@TerC/D), 283(IntPkwy@TerE), 414(IntPkwy@AirDr_S), 415(IntPkwy@RenCarDr), 416(IntPkwy/TXSpr97), 417(TXSpr97/TX183), 440(TX183@AmonCarBlvd), 445(TX183/TX360), 451(TX360@TriBlvd), 450(TX360@RivPkwy), 449(TX360@PostPadRd), 446(TX360@CarPkwy), 556(TX360@AveK), 555(TX360@AveH), 535(I-30(30A)/TX360), 559(TX360@SixFlaDr), 558(TX360@RanMilRd), 552(TX180/TX360), 553(TX360@AbrSt), 557(TX360@ParkRowDr), 545(TXSpr303/TX360), 554(TX360@ArkLn), 642(TX360@MayRd), 637(I-20(453)/TX360), 641(TX360@GreOaksBlvd), 640(TX360@CampWisRd), 645(TX360@WebbLynnRd), 643(TX360@NewYorkAve), 644(TX360@RagRd), 663(TX360@HolRd), 661(TX360@BroSt), 662(TX360@HerPkwy), 664(TX360@LoneStarRd), 665(TX360/US287), 724(US287@FM661), 1345(US287_N/US287BusMid_N), 1328(US67/US287)]

Distance from 740(TX121@DenTapRd) to 1328(US67/US287) = 40.826521 miles
Path size = 48
Poll count = 1,574
```