import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;
public class Graph {
    AdjList adjList;
    private static HashMap <Long, Node> IDMap = new HashMap<>();
    private static final int numOfIDs = 4507;
    private static final File file1 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_nodes.csv");
    private static final File file2 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_edges.csv");
    private static Node Nodes [] = new Node[numOfIDs];
    
    public Graph (AdjList adjList) {
        this.adjList = adjList;
    }

    public Graph() throws FileNotFoundException {
        this.adjList = new AdjList();
        this.adjList.loadNodes();
        this.adjList.loadEdges();
    }

    public void show(Node node) {
        System.out.println(node);
        System.out.println(adjList.adjMap.get(node));
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_nodes.csv");
        Scanner nodesFile = new Scanner(file1);
        File file2 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_edges.csv");
        Scanner edgesFile = new Scanner(file2);


        Graph graph = new Graph();
        graph.show(Nodes[2]);
        
    }
}