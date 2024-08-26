import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
public class AdjList {
    public final int numOfIDs = 4507;
    HashMap <Long, Node> IDmap = new HashMap<>();
    Node Nodes [];
    File file1 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_nodes.csv");
    File file2 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_edges.csv");
    HashMap <Node, ArrayList<Edge>> adjMap = new HashMap<>();

    public AdjList(HashMap <Node, ArrayList<Edge>> adjList ) {
        this.adjMap = adjMap;
    }
    public AdjList () {
        adjMap = new HashMap<>();
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

    
    public void loadNodes() throws FileNotFoundException {
        Scanner nodesFile = new Scanner(file1);
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
                }
        
        }
        nodesFile.close();

      //  for (int i = 0; i < numOfIDs; i++) {
     //       System.out.println(Nodes[i]);
      //  }

    }
    public void loadEdges() throws FileNotFoundException {
        Scanner edgesFile = new Scanner(file2);
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
            }

            
        }

     //   for (Node node : adjMap.keySet()) {
       //     System.out.println(node + " -> " + adjMap.get(node));
      //  }
        edgesFile.close();
        
        
        
    
}

    public static void main(String[] args) throws FileNotFoundException {
        AdjList list = new AdjList();
        list.loadNodes();
        list.loadEdges();
    }
}


    
        
       


    

