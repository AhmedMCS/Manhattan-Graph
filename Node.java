import java.math.BigDecimal;
import java.util.ArrayList;
public class Node {
    long ID;
    BigDecimal x;
    BigDecimal y;
    ArrayList <Edge> edgeList;
    
    public Node (long ID, BigDecimal x, BigDecimal y ) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.edgeList = new ArrayList<>();
        
    }

    public Node() {
        this.ID = 0;
        this.x = null;
        this.y = null;
        this.edgeList = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }
    

    public String toString () {
        return "Node: (ID: " + ID + " x: " + x + " y: " + y + ")";
    }

    
    
    
    
    
}