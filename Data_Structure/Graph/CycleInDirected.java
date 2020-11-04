import java.io.*;
import java.util.*;

import javax.swing.border.EtchedBorder;

class Graph{
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    private boolean[] visitors;
    private boolean[] inpath;
    Graph(int vertices){
        V = vertices;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertices;i++)
            adj.add(new ArrayList<Integer>());
    }
    void AddEdge(int u,int v){
        adj.get(u).add(v);
    }

    void printEdge(){
        for(int i=0;i<adj.size();i++){
            System.out.print(i+" -> ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" -> ");
            }
            System.out.print("NULL");
            System.out.println();
        }
    }

    boolean isCyclicUntil (int start,boolean[] visited,boolean[] recStack) {
        visited[start] = true; 
        recStack[start] = true; 
        List<Integer> children = adj.get(start); 
        for (Integer c: children){
            if(inpath[c])
                return true;
            else if(visited[c])
                isCyclicUntil(c, visited, recStack);
        }       
        recStack[i] = false; 
        return false; 
 
    }

    boolean isCycleDirect(int start){
        visitors = new boolean[V];
        inpath = new boolean[V];
        Arrays.fill(visitors,false);
        Arrays.fill(inpath,false);
        return isCyclicUntil(start,visitors,inpath);
    }


}
public class CycleInDirected {
    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);
        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 1);
        graph.AddEdge(3, 5);
        graph.AddEdge(4, 6);
        graph.AddEdge(5, 4);
        graph.AddEdge(6, 5);
        
        graph.printEdge();
        if(graph.isCycleDirect(0))
            System.out.println("Cycle Present in Graph");
        else
            System.out.println("Cycle not present in Graph");

    }
}
