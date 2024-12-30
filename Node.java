import java.math.BigDecimal;
public class Node {
    long ID;
    BigDecimal x;
    BigDecimal y;
    
    public Node (long ID, BigDecimal x, BigDecimal y ) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        
    }

    public Node() {
        this.ID = 0;
        this.x = null;
        this.y = null;
    }
    

    public String toString () {
        return "Node: (ID: " + ID + " X: " + x + " Y: " + y + ")";
    }

    
    
    
    
    
}
