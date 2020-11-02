import java.io.*;
import java.util.*;

class Graph{
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    private boolean[] visitors;
    private boolean[] inpath;
    private boolean cyclePresent = false;
    Graph(int vertices){
        V = vertices;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++)
            adj.add(new ArrayList<Integer>());
    }
    void AddEdge(int u,int v){
        adj.get(u).add(v);
    }

    void isCycle (int src) {

        visitors[src] = true;
        inpath[src] = true;
        Iterator iterator = adj.get(src).iterator();
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            if(inpath[temp]){
                cyclePresent = true;
                return;
            }else if(!visitors[temp]){
                isCycle(temp);
            }
        }
        inpath[src] = false;
    }

    boolean isCycleDirect(int start){
        visitors = new boolean[V];
        inpath = new boolean[V];
        for(int i=0;i<V;i++){
            visitors[i] =  false;
            inpath[i] = false;
        }
        isCycle(start);
        if(cyclePresent)
            return true;
        return false;
    }


}
public class CycleInDirected {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 1);
        graph.AddEdge(3, 4);
        

        if(graph.isCycleDirect(0))
            System.out.println("Cycle Present in Graph");
        else
            System.out.println("Cycle not present in Graph");

    }
}
