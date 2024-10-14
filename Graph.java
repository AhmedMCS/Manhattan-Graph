import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
public class Graph {
    AdjList adjList;
    private static final int numOfIDs = 4507;
    private static final File NODES_FILE = new File("manhattan_nodes.csv");
    private static final File EDGES_FILE = new File("manhattan_edges.csv");
    
    public Graph (AdjList adjList) {
        this.adjList = adjList;
    }

    public Graph() throws FileNotFoundException {
        this.adjList = new AdjList();
        this.adjList.loadNodes();
        this.adjList.loadEdges();
    }
    
    public void shortestPath (Node source, Node target) {
        HashMap <Node, Double> dist = new HashMap<>();
        HashMap <Node, Node> prev = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Double.compare(dist.get(n1), dist.get(n2)));
        dist.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (currentNode.equals(target)) {
                break;
            }

            ArrayList<Edge> neighbors = adjList.adjMap.get(currentNode);

            for (Edge edge : neighbors) {
                Node neighbor = edge.target;
                Double newDistance = dist.get(currentNode) + edge.weight;

                if (!dist.containsKey(neighbor) || newDistance < dist.get(neighbor)) {
                    dist.put(neighbor, newDistance);
                    prev.put(neighbor, currentNode);
                    pq.add(neighbor);
                } 


            }


        }

        printPath(source, target, prev, dist);
    }

    private void printPath(Node source, Node target, HashMap<Node, Node> prev, HashMap<Node, Double> dist) {
        if (!dist.containsKey(target)) {
            System.out.println("No path found");
            return;
        }
    
        ArrayList<Node> path = new ArrayList<>();
        Node step = target;
        
        while (prev.containsKey(step)) {
            path.add(0, step);  
            step = prev.get(step);
        }
    
        path.add(0, source);  
        System.out.println("Shortest path: ");
        for (Node node : path) {
            System.out.print(node + " ");
        }
    
        System.out.println("\nTotal Distance: " + dist.get(target));
    }
    

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph();
        Node source = graph.adjList.getNode(5);
        Node target = graph.adjList.getNode(2500);
        graph.shortestPath(source, target);


        
    }
}
