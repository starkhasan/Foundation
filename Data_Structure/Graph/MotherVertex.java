import java.io.*;
import java.util.*;
class Graph{
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    Graph(int vertices){
        V = vertices;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
    }
    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print(i+" -> ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" -> ");
            }
            System.out.print(" NULL");
            System.out.println();
        }
    }

    void DFSUntil(int start,boolean[] visited){
        visited[start] = true;
        Iterator iterator = adj.get(start).iterator();
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            if(!visited[temp]){
                DFSUntil(temp, visited);
            }
        }
    }
    void MotherVertexFind(){
        boolean[] visited = new boolean[V];
        int count = 0;
        boolean isVisited = true;
        for(int i=0;i<V;i++){
            isVisited = true;
            Arrays.fill(visited, false);
            DFSUntil(i, visited);
            for(boolean isContain:visited){
                if(!isContain){
                    isVisited = false;
                    break;
                }
            }
            if(isVisited){
                count++;
                System.out.println(i+" is the Mother Vertex");
            }
        }
        if(count==0)
            System.out.println("No Mother Vertex Found in Graph");
    }

}
public class MotherVertex {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int vertices = 0;
        while((buffer.readLine())!=null){
            vertices = Integer.parseInt(buffer.readLine());
        }
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 2);
        graph.addEdge(6, 0);
        graph.printGraph();
        System.out.println("\nMother Vertex Search  : ");
        graph.MotherVertexFind();
        buffer.close();
    }
}
