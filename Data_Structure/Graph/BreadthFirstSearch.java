package Graph;
import java.util.*;
import java.io.*;
class Graph{
    public int V;
    public ArrayList<Integer> adj[];
    Graph(int data){
        V = data;
        adj = new ArrayList[data];
        for(int i=0;i<data;i++)
            adj[i] = new ArrayList<Integer>();
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
    }
    public void printGraph(){ 
        for (int i = 0; i < adj.length; i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < adj[i].size(); j++) { 
                System.out.print(" -> "+adj[i].get(j)); 
            } 
            System.out.println(); 
        } 
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V]; 
        ArrayList<Integer> queue = new ArrayList<Integer>(); 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0){
            // Dequeue a vertex from queue and print it 
            s = queue.remove(queue.size()-1); 
            System.out.print(s+" "); 
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()){
                int n = i.next(); 
                if (!visited[n]){ 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
}
public class BreadthFirstSearch {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number of Vertices : ");
        int vertices = Integer.parseInt(buffer.readLine());
        Graph graph = new Graph(vertices);
        System.out.println("Enter Source and Destination Vertices : ");
        for(int i=0;i<vertices;i++){
            System.out.print("\nSource : ");
            int source = Integer.parseInt(buffer.readLine());
            System.out.print("Destination : ");
            int destination = Integer.parseInt(buffer.readLine());
            graph.addEdge(source, destination);
        }
        graph.printGraph();
        System.out.println("\nEnter Starting Node for BFS: ");
        graph.BFS(Integer.parseInt(buffer.readLine()));
    }
}
