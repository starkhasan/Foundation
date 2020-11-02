import java.util.*;
import java.io.*;
public class AdjacencyList {
    static void addEdge(LinkedList<LinkedList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void printGraph(LinkedList<LinkedList<Integer> > adj){ 
        for (int i = 0; i < adj.size(); i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(" -> "+adj.get(i).get(j)); 
            System.out.println(); 
        } 
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of Vertices : ");
        int vertices = Integer.parseInt(buffer.readLine());
        LinkedList<LinkedList<Integer>> adj = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < vertices; i++) 
            adj.add(new LinkedList<Integer>());
        addEdge(adj, 0, 1); 
        addEdge(adj, 0, 4); 
        addEdge(adj, 1, 2); 
        addEdge(adj, 1, 3); 
        addEdge(adj, 1, 4); 
        addEdge(adj, 2, 3); 
        addEdge(adj, 3, 4); 
        printGraph(adj);
        buffer.close();
    }
}
