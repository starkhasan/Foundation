package Tree;
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
public class BinaryTree{
    static int count=0,count1=0,count2=0;

    public Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node cur = root;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }else{
                cur = insert(root.right, data);
                root.right = cur;
            }
        }
        return root;
    }

    public int get_height(Node focusNode){
        int max = 0;
        if(focusNode == null)
            return 0;
        int ldepth=get_height(focusNode.left);
        int rdepth=get_height(focusNode.right);
        if(ldepth>rdepth)
            max = ldepth+1;
        else
            max = rdepth+1;
        return max;
    }
    public int tree_height(Node focusNode){
        int depth_tree = get_height(focusNode);
        return (depth_tree-1);
    }
    public void swap(Node temp){
        if(temp == null)
            return;
        Node temp1=temp.left;
        temp.left=temp.right;
        temp.right=temp1;
    }
    public void Mirror(Node headref){
        if(headref==null)
            return;
        Mirror(headref.left);
        Mirror(headref.right);
        swap(headref);
    }

    public void Inorder(Node focuseNode){
        if(focuseNode!=null){
            Inorder(focuseNode.left);
            System.out.print(focuseNode.data+" ");
            Inorder(focuseNode.right);
        }
    }

    public void Postorder(Node focusNode){
        if(focusNode!=null){
            Postorder(focusNode.left);
            Postorder(focusNode.right);
            System.out.print(focusNode.data+" ");
        }
    }

    public void Preorder(Node focuseNode){
        if(focuseNode!=null){
            System.out.print(focuseNode.data+" ");
            Preorder(focuseNode.left);
            Preorder(focuseNode.right);
        }
    }

    public void BFS(Node focusNode){
        int level=get_height(focusNode);
        for(int i=1;i<=level;i++){
            printLevel(focusNode,i);
        }
    }

    public void printLevel(Node focusNode,int level){
        if(focusNode!=null){
            if(level==1)
                System.out.print(focusNode.data+" ");
            else if(level>1){
                printLevel(focusNode.left, level-1);
                printLevel(focusNode.right, level-1);
            }
        }
    }

    public int leavs_count(Node focusNode){
        if(focusNode==null)
            return 0;
        
        if(focusNode.left==null && focusNode.right==null)
            count++;

        leavs_count(focusNode.left);
        leavs_count(focusNode.right);
        return  count;
    }

    public int Non_leaf(Node focuNode){
        if(focuNode==null)
            return 0;

        if(focuNode.left!=null || focuNode.right!=null)
            count1++;

        Non_leaf(focuNode.left);
        Non_leaf(focuNode.right);
        return count1;
    }

    public int Both_Node(Node foccusNode){
        if(foccusNode==null){
            return 0;
        }
        if(foccusNode.left!=null && foccusNode.right!=null){
            count2++;
        }
        Both_Node(foccusNode.left);
        Both_Node(foccusNode.right);
        return count2;
    }

    public int Count_Element(){
        return (count+count1);
    }

    public Node lca(Node focusNode,int node1,int node2){
        if(focusNode.data > node1 && focusNode.data > node2){
            return lca(focusNode.left, node1, node2);
        }else if(focusNode.data < node1 && focusNode.data < node2){
            return lca(focusNode.right,node1,node2);
        }else{
            return focusNode;
        }
    }

    private boolean isBinaryTree(Node root,int min,int max){
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return isBinaryTree(root.left, min,root.data-1) && isBinaryTree(root.right, root.data+1, max);
    }
    
    public static void main(String [] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree d = new BinaryTree();
        Node root = null;
        System.out.println("Enter Tree Size : ");
        int tree_size = Integer.parseInt(buffer.readLine());
        System.out.println("Insert Element in Tree : ");
        for(int i=0;i<tree_size;i++){
            root = d.insert(root,Integer.parseInt(buffer.readLine()));
        }
        System.out.println("Inorder Traversal of Binary Tree : ");
        d.Inorder(root);
        System.out.println("\nPreorder Traversal of Binary Tree : ");
        d.Preorder(root);
        System.out.println("\nPostorder Traversal of Binary Tree : ");
        d.Postorder(root);

        int depth_tree=d.tree_height(root);
        System.out.println("\nHeight of Binary Tree : "+depth_tree);
        System.out.println("Depth First Search of Binary Search Tree : ");
        d.Preorder(root);
        System.out.println("\nBreadth First Search of Binary Search Tree : ");
        d.BFS(root);
        

        System.out.println("\n\nMirror of Binary Tree : ");
        d.Mirror(root);
        System.out.println("\nBreadth First Search of Binary Search Tree : ");
        d.BFS(root);
        System.out.println("\nInorder Traversal of Binary Tree : ");
        d.Inorder(root);
        System.out.println("\nPost Order");
        d.Postorder(root);

        System.out.print("\nNumber of Leaf Node in Binary Tree : ");
        int leavs=d.leavs_count(root);
        System.out.println(leavs);

        System.out.print("\nNumber of Non-Leaf Node in Binary Tree : ");
        int nonleaf=d.Non_leaf(root);
        System.out.println(nonleaf);

        System.out.print("\nNumber of Node which have Both Left and Right Child : ");
        int bothnode=d.Both_Node(root);
        System.out.println(bothnode);

        System.out.print("\nTotal Number of Element in Tree : ");
        int total_element=d.Count_Element();
        System.out.print(total_element);
        System.out.println("Enter the Nodes to Check the common Ansestor : ");
        int node1 = Integer.parseInt(buffer.readLine());
        int node2 = Integer.parseInt(buffer.readLine());
        Node lcavalues = d.lca(root,node1,node2);
        System.out.print("Lowest Common Ansestor = "+lcavalues.data);
        System.out.println("Check for the Binary Search Tree : ");
        if(d.isBinaryTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            System.out.println("It's BST");
        }else{
            System.out.println("No BST");
        }
        buffer.close();
    }
}
