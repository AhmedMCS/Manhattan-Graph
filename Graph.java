import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
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
    
    public ArrayList<Node> shortestPath (Node source, Node target) {
        HashMap <Node, Double> dist = new HashMap<>();
        HashMap <Node, Node> prev = new HashMap<>();
        for (Node node : adjList.adjMap.keySet()) {
            dist.put(node, Double.MAX_VALUE);
            prev.put(node, null);
        }
        PriorityQueue <Node> pq = new PriorityQueue<>();
        dist.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (currentNode.equals(target)) {
                
            }


        }


    }
    

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph();
        Node node5 = graph.adjList.getNode(5);
        ArrayList <Edge> node5Edge = graph.adjList.getEdge(node5);
        System.out.println(node5);
        System.out.println(node5Edge);


        
    }
}