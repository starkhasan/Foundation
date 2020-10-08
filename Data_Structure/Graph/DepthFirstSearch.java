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

    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()){
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v){
        boolean visited[] = new boolean[V]; 
        DFSUtil(v, visited); 
    }

}
public class DepthFirstSearch {
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
        System.out.println("\nEnter Starting Node for DFS: ");
        graph.DFS(Integer.parseInt(buffer.readLine()));
    }
}
