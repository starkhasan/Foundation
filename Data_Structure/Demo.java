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
class Demo{
    static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node cur = root;
            if(root.data > data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur = insert(root.right, data);
                root.right = cur;
            }
        }
        return root;
    }
    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }
    static int height(Node root){
        int max = 0;
        if(root == null){
            return 0;
        }
        int ldepth = height(root.left);
        int rdepth = height(root.right);
        if(ldepth>rdepth){
            max = ldepth+1;
        }else{
            max = rdepth+1;
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
       BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
       Node root = null;
       System.out.println("Enter Size of tree : ");
       int tree_size = Integer.parseInt(buffer.readLine());
       int count = 0;
       while(count<tree_size){
           root = insert(root,Integer.parseInt(buffer.readLine()));
           count++;
       } 
       inorder(root);
       System.out.println("\nHeight of Tree ; ");
       int h = height(root);
       System.out.println(h);
       buffer.close();
    }
}

