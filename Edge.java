import java.util.ArrayList;

public class Edge  {
    Node target;
    double weight;
    ArrayList<Edge> edgeList;

    public Edge (Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }

    public Edge () {
        this.target = null;
        this.weight = 0.0;
    }

    public String toString() {
        return "(Edge: (" + "targetID:" + target.ID +", weight: " + weight + ")";
    }

}
