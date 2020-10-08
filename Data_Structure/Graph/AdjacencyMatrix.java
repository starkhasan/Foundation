import java.io.*;
class Graph{
    int vertices;
    int[][] adjMatrices;
    public Graph(int vertices){
        this.vertices = vertices;
        adjMatrices = new int[vertices][vertices];
        assignMatrix();
    }

    void assignMatrix(){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                adjMatrices[i][j] = 0;
            }
        }
    }

    void addEdge(int u,int v){
        adjMatrices[u][v] = 1;
        adjMatrices[v][u] = 1;
    }
    
    void printGrapgh(){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjMatrices[i][j]+" ");
            }
            System.out.println();
        }
    }
}
public class AdjacencyMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of Vertices : ");
        int vertices = Integer.parseInt(buffer.readLine());
        Graph graph = new Graph(vertices);
        System.out.println("Connect the Source and Destination");
        for(int i=0;i<vertices;i++){
            System.out.println("Destination vertex of "+i);
            String[] destination = buffer.readLine().split(" ");
            for(int j=0;j<destination.length;j++){
                if(Integer.parseInt(destination[j]) == i)
                    continue;
                else
                    graph.addEdge(i,Integer.parseInt(destination[j]));
            }
        }
        System.out.println("Graph Representation using Adjacency Matrix : ");
        graph.printGrapgh();
    }
}
