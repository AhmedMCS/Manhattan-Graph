import java.util.ArrayList;

public class Edge {
    long targetID;
    double weight;
    ArrayList<Edge> edgeList;

    public Edge (long targetID, double weight) {
        this.targetID = targetID;
        this.weight = weight;
    }

    public Edge () {
        this.targetID = 0;
        this.weight = 0.0;
    }

    public String toString() {
        return "targetID: " + targetID +", weight: " + weight;
    }

}
