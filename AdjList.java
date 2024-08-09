import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
public class AdjList {
    Scanner nodesFile;
    Scanner edgesFile;
    public AdjList (Scanner nodesFile, Scanner edgesFile) {
        this.nodesFile = nodesFile;
        this.edgesFile = edgesFile;
    }

    public void loadList() throws FileNotFoundException {
        File file1 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_nodes.csv");
        Scanner nodesFile = new Scanner(file1);
        nodesFile.nextLine();
        int numOfIDs = 4507;
        Node Nodes [] = new Node [numOfIDs];
        HashMap <Long, Node> mapID = new HashMap<>();
        
        for (int i = 0; i < numOfIDs && nodesFile.hasNextLine(); i++) {
            String line = nodesFile.nextLine();
            String [] parts = line.split(",");
                if (parts.length >= 3 && !parts[0].isEmpty() && !parts[1].isEmpty() && !parts[2].isEmpty()) {
                    long ID = Long.parseLong(parts[0]);  
                    BigDecimal x = new BigDecimal(parts[1]);
                    BigDecimal y = new BigDecimal(parts[2]);
                    Nodes[i] = new Node(ID, x, y);
                    mapID.put(ID, Nodes[i]);
                }
        
        }
        nodesFile.close();
    
        File file2 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_edges.csv");
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
                Edge edge = new Edge(targetID, weight);
                Node sourceNode = mapID.get(sourceID);
                Node targetNode = mapID.get(targetID);

                if (sourceNode != null && targetNode != null) {
                    sourceNode.addEdge(edge);
                }
            }
            
        }
        edgesFile.close();
        for (int i = 0; i < numOfIDs; i++) {
            System.out.println(Nodes[i].edgeList);
        }
        
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_nodes.csv");
        Scanner nodesFile = new Scanner(file1);
        File file2 = new File("C:\\Users\\ahmed\\Documents\\Programming\\Personal Projects\\Project Manhattan\\manhattan_edges.csv");
        Scanner edgesFile = new Scanner(file2);
        AdjList AdjList = new AdjList(nodesFile, edgesFile);

        AdjList.loadList();
        
    }
    

}
        
       


    

