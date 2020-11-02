import java.util.*;
import java.io.*;
class Graph{
    private int V;
    private ArrayList<ArrayList<Integer>> adjList;
    Graph(int vertex){
        V = vertex;
        adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<Integer>());
    }
    public void addEdge(int u,int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void printGraph(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i+" -> ");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)+" -> ");
            }
            System.out.print("NULL");
            System.out.println();
        }
    }
    public void BFS(int start){
        boolean[] visited = new boolean[V];
        visited[start] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(queue.size()!=0){
            int temp = queue.poll();
            System.out.print(temp+" ");
            Iterator iterator = adjList.get(temp).iterator();
            while(iterator.hasNext()){
                int temp1 = (int)iterator.next();
                //System.out.print("Node = "+temp1);
                if(!visited[temp1]){
                    visited[temp1] = true;
                    queue.add(temp1);
                }
            }
        }
    }


    public void DepthFirstSearch(int start,boolean[] visited){
        visited[start] = true;
        System.out.print(start+" ");
        Iterator iterator = adjList.get(start).iterator();
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            if(!visited[temp]){
                DepthFirstSearch(temp, visited);
            }
        }
    }
    public void DFS(int start){
        boolean[] visited = new boolean[V];
        DepthFirstSearch(start,visited);
    }

    
}
class Demo{
    public static void main(String[] args){
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Size of Vertex : ");
            int vertex = Integer.parseInt(buffer.readLine());
            Graph graph = new Graph(vertex);
            System.out.println("Enter Vertices : ");
            graph.addEdge(0, 1); 
            graph.addEdge(0, 4); 
            graph.addEdge(1, 2); 
            graph.addEdge(1, 3); 
            graph.addEdge(1, 4); 
            graph.addEdge(2, 3); 
            graph.addEdge(3, 4); 
            graph.printGraph();

            //System.out.println("BFS");
            //graph.BFS(2);
            System.out.println("DFS");
            graph.DFS(2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}