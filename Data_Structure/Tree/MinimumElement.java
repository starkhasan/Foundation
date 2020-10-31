import java.io.*;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class MinimumElement {
    static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node cur = root;
            if(data < root.data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur = insert(root.right,data);
                root.right = cur;
            }
        }
        return root;
    }
    static void inorder(Node focusNode,List<Integer> listNode){
        if(focusNode!=null){
            inorder(focusNode.left,listNode);
            listNode.add(focusNode.data);
            inorder(focusNode.right, listNode);
        }
    }
    static int minValue(Node node){
        if(node==null){
            return -1;
        }else{
            List<Integer> listNode = new ArrayList<>();
            inorder(node,listNode);
            return listNode.get(0);
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int size = 0;
        String input = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                size = Integer.parseInt(buffer.readLine());
            }else{
                input = buffer.readLine();
            }
        }
        String[] strAr = input.split(" ");
        for(int i=0;i<size;i++){
            root = insert(root,Integer.parseInt(strAr[i]));
        }
        System.out.println("\n Min Element in BST = "+minValue(root));
        sc.close();
        buffer.close();
        
    } 
}
