import java.io.*;
import java.util.*;
class Graph{
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    boolean isCyclicUntil(int v,boolean[] visitor,int parent){
        visitor[v] = true;
        Iterator it = adj.get(v).iterator();
        while(it.hasNext()){
            int temp = (int)it.next();
            if(!visitor[temp]){
                if(isCyclicUntil(temp, visitor, v)) 
                    return  true;
            }else if(temp!=parent){
                return true;
            }
        }
        return false;
    }
    boolean isCyclic(){
        boolean[] visitor = new boolean[V];
        for(int i=0;i<V;i++)
            visitor[i] = false;
        for(int j=0;j<V;j++){
            if(!visitor[j])
                if(isCyclicUntil(j,visitor,-1))
                    return true;
        }
        return false;
    }
}
public class CycleInUnDirected {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int vertices = 3;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1); 
        graph.addEdge(1, 2); 
        if(graph.isCyclic())
            System.out.println("Visited");
        else
            System.out.println("Not Cycle");
        buffer.close();
    }
}
