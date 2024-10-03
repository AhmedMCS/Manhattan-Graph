import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
public class AdjList {
    public final int numOfIDs = 4507;
    private HashMap <Long, Node> IDmap = new HashMap<>();
    private Node Nodes [];
    private static final File NODES_FILE = new File("manhattan_nodes.csv");
    private static final File EDGES_FILE = new File("manhattan_edges.csv");
    HashMap <Node, ArrayList<Edge>> adjMap = new HashMap<>();

    public AdjList() {
        Nodes = new Node[numOfIDs];
    }

    public void addNode (Node node) {
        if (!adjMap.containsKey(node)) {
            adjMap.put(node, new ArrayList<Edge>());
        }

    }

    public void addEdge (Node sourceNode, Node targetNode, Double weight) {
        addNode(targetNode);
        addNode(sourceNode);
        Edge edge = new Edge(targetNode, weight);
        adjMap.get(sourceNode).add(edge);
    }

    public Node getNode (int index) {
        if (index > numOfIDs || index < 0) {
            throw new IndexOutOfBoundsException("Invalid node index"); 
        }
        return Nodes[index];
        
    }

    public ArrayList <Edge> getEdge (Node node) {
        return adjMap.get(node);
    }

    
    public void loadNodes() throws FileNotFoundException {
        Scanner nodesFile = new Scanner(NODES_FILE);
        nodesFile.nextLine();
        Nodes = new Node [numOfIDs];
        
        for (int i = 0; i < numOfIDs && nodesFile.hasNextLine(); i++) {
            String line = nodesFile.nextLine();
            String [] parts = line.split(",");
                if (parts.length >= 3 && !parts[0].isEmpty() && !parts[1].isEmpty() && !parts[2].isEmpty()) {
                    long ID = Long.parseLong(parts[0]);  
                    BigDecimal x = new BigDecimal(parts[1]);
                    BigDecimal y = new BigDecimal(parts[2]);
                    Nodes[i] = new Node(ID, x, y);
                    IDmap.put(ID, Nodes[i]);
                    addNode(Nodes[i]);
                    System.out.println("Node: " + ID + " [x: " + x + ", y: " + y + "]");
                }
            
        
        }


        nodesFile.close();
    }
    public void loadEdges() throws FileNotFoundException {
        Scanner edgesFile = new Scanner(EDGES_FILE);
        edgesFile.nextLine();
        int numOfEdges = edgesFile.nextInt();

        for (int i = 0; i < numOfEdges && edgesFile.hasNextLine(); i++) {
            String line = edgesFile.nextLine();
            String [] parts = line.split(",");
            if (parts.length >= 3 && !parts[0].isEmpty() && !parts[1].isEmpty() && !parts[2].isEmpty()) {
                long sourceID = Long.parseLong(parts[0]);
                long targetID = Long.parseLong(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                Node sourceNode = IDmap.get(sourceID);
                Node targetNode = IDmap.get(targetID);

                if (sourceNode != null && targetNode != null) {
                    addEdge(sourceNode, targetNode, weight);
                }

                System.out.println("Edge: " + sourceID + " -> " + targetID + " [Weight: " + weight + "]");
            }

            
        }

        
        edgesFile.close();
        
}

    public static void main(String[] args) throws FileNotFoundException {
        AdjList list = new AdjList();
        list.loadNodes();
        list.loadEdges();
    }
}
