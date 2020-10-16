package Tree;
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class TopViewTree {
    Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node cur = null;
            if(data <= root.data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur = insert(root.right,data);
                root.right = cur;
            }
        }
        return root;
    }
    int treeHeight(Node focusNode){
        int max = 0;
        if(focusNode==null){
            return 0;   
        }
        int ldepth = treeHeight(focusNode.left);
        int rdepth = treeHeight(focusNode.right);
        if(ldepth>rdepth)
            max = ldepth+1;
        else
            max = rdepth+1;
        return max;
    }
    void printLevel(Node focusNode,int level,int hd,HashMap<Integer,Integer> hd_dis){
        if(focusNode!=null){
            if(level==1){
                System.out.print(focusNode.data+" ");
                if(!hd_dis.containsKey(hd))
                    hd_dis.put(hd,focusNode.data);
            }else if(level>1){
                printLevel(focusNode.left, level-1,hd-1,hd_dis);
                printLevel(focusNode.right,level-1,hd+1,hd_dis);
            }
        }
    }
    HashMap<Integer,Integer> BFS(Node focusNode,int horizontal_distance,HashMap<Integer,Integer> hd){
        int level = treeHeight(focusNode);
        for(int i=1;i<=level;i++){
            printLevel(focusNode,i,horizontal_distance,hd);
        }
        return hd;
    }
    void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }
    
    private <T extends Comparable<T>> void sort(T[] keys) {
        for(int j=1;j<keys.length;j++){
            T key = keys[j];
            int i = j - 1;
            while(i>=0 && keys[i].compareTo(key) > 0){
                keys[i+1] = keys[i];
                i-=1;
            }
            keys[i+1] = key;
        }
    }

    public static void main(String[] args) throws IOException{
        TopViewTree d = new TopViewTree();
        Node root = null;
        HashMap<Integer,Integer> hd = new HashMap<>();
        String line = "";
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        while((buffer.readLine()!=null)){
            line = buffer.readLine();
        }
        String[] strAr = line.split(" ");
        for(int i=0;i<strAr.length;i++){
            root = d.insert(root,Integer.parseInt(strAr[i]));
        }
        System.out.println("\nInorder Traversal");
        d.inorder(root);
        System.out.println("\nBreadth First Search");
        HashMap<Integer,Integer> bottomView = d.BFS(root,0,hd);
        System.out.println("\nBottom View");
        Object[] keys = bottomView.keySet().toArray();
        Integer[] element = new Integer[keys.length];
        for(int i=0;i<keys.length;i++){
            element[i] = (Integer)keys[i];
        }
        d.sort(element);
        for(int i=0;i<keys.length;i++){
            System.out.println(bottomView.get(element[i])+" ");
        }
        buffer.close();
    }
}
