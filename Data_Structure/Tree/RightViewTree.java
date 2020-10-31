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
public class RightViewTree {
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
    void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
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
    public void printLevel(Node focusNode,int level,ArrayList<Integer> ele){
        if(focusNode!=null){
            if(level==1){
                ele.add(focusNode.data);
            }else if(level>1){
                printLevel(focusNode.left, level-1,ele);
                printLevel(focusNode.right,level-1,ele);                
            }
        }
    }
    public void RightView(Node focusNode){
        ArrayList<Integer> firstElement;
        int level = treeHeight(focusNode);
        for(int i=1;i<=level;i++){
            firstElement = new ArrayList<Integer>();
            printLevel(focusNode,i,firstElement);
            System.out.print(firstElement.get(firstElement.size()-1)+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        RightViewTree d = new RightViewTree();
        Node root = null;
        //HashMap<Integer,Integer> hd = new HashMap<>();
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
        System.out.println("\nRight View Tree");
        d.RightView(root);
        buffer.close();
    }
}
