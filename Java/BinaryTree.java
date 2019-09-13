
import java.util.Scanner;
class demo
{
    Node root;
    static class Node
    {
        Node left,right;
        int data;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }

    //ali hasan
    public void insert(int data)
    {

        if(root==null)
        {
            root=new Node(data);
        }
        else
        {
            Node focusNode=root;
            Node present;
            while(true)
            {
                present=focusNode;
                if(focusNode.data>=data)
                {
                    focusNode=focusNode.left;
                    if(focusNode==null)
                    {
                        present.left=new Node(data);
                        return;
                    }
                }
                else
                {
                    focusNode=focusNode.right;
                    if(focusNode==null)
                    {
                        present.right=new Node(data);
                        return;
                    }
                }
                
            }

        }

    }

    public int get_height(Node focusNode)
    {
        if(focusNode==null)
        {
            return 0;
        }
        int ldepth=get_height(focusNode.left);
        int rdepth=get_height(focusNode.right);
        if(ldepth>rdepth)
        {
            return (ldepth+=1);
        }
        else
        {
            return (rdepth+=1);
        }
    }
    public int tree_height(Node focusNode)
    {
        int depth_tree=get_height(focusNode);

        return (depth_tree-1);
    }
    public void swap(Node temp)
    {
        {
        if(temp==null)
            return;
        }
        Node temp1=temp.left;
        temp.left=temp.right;
        temp.right=temp1;

    }
    public void Mirror(Node headref)
    {
        if(headref==null)
        {
            return;
        }
        Mirror(headref.left);
        Mirror(headref.right);
       
        swap(headref);

    }

    public void Inorder(Node focuseNode)
    {

        if(focuseNode!=null)
        {
            Inorder(focuseNode.left);
            System.out.print(focuseNode.data+" ");
            Inorder(focuseNode.right);
        }

    }

    public void Postorder(Node focusNode)
    {
        if(focusNode!=null)
        {
            Postorder(focusNode.left);
            Postorder(focusNode.right);
            System.out.print(focusNode.data+" ");
        }
    }

    public void Preorder(Node focuseNode)
    {
        if(focuseNode!=null)
        {
            System.out.print(focuseNode.data+" ");
            Preorder(focuseNode.left);
            Preorder(focuseNode.right);
        }
    }

    public void BFS(Node focusNode)
    {
        int level=get_height(focusNode);
        for(int i=1;i<=level;i++)
        {
            printLevel(focusNode,i);
        }
    }

    public void printLevel(Node focusNode,int level)
    {
        if(focusNode==null)
        {
            return;
        }
        if(level==1)
        {
            System.out.print(focusNode.data+" ");
        }
        else if(level>1)
        {
            printLevel(focusNode.left, level-1);
            printLevel(focusNode.right, level-1);
        }
    }
    static int count=0,count1=0,count2=0;
    public int leavs_count(Node focusNode)
    {
        if(focusNode==null)
        {
            return 0;
        }
        if(focusNode.left==null && focusNode.right==null)
        {
            count++;
        }
        leavs_count(focusNode.left);
        leavs_count(focusNode.right);

        return  count;
    }

    public int Non_leaf(Node focuNode)
    {
        if(focuNode==null)
        {
            return 0;
        }
        if(focuNode.left!=null || focuNode.right!=null)
        {
            count1++;
        }
        Non_leaf(focuNode.left);
        Non_leaf(focuNode.right);

        return count1;

    }

    public int Both_Node(Node foccusNode)
    {
        if(foccusNode==null)
        {
            return 0;
        }
        if(foccusNode.left!=null && foccusNode.right!=null)
        {
            count2++;
        }
        Both_Node(foccusNode.left);
        Both_Node(foccusNode.right);


        return count2;
    }

    public int Count_Element()
    {
        return (count+count1);
    }
    
    public static void main(String [] args)
    {

        Scanner sc=new Scanner(System.in);
        demo d=new demo();
        System.out.println("Enter Tree Size : ");
        int tree_size=sc.nextInt();
        System.out.println("Insert Element in Tree : ");
        for(int i=0;i<tree_size;i++)
        {
            d.insert(sc.nextInt());
        }
        
        System.out.println("Inorder Traversal of Binary Tree : ");
        d.Inorder(d.root);
        System.out.println("\nPreorder Traversal of Binary Tree : ");
        d.Preorder(d.root);
        System.out.println("\nPostorder Traversal of Binary Tree : ");
        d.Postorder(d.root);

        int depth_tree=d.tree_height(d.root);
        System.out.println("\nHeight of Binary Tree : "+depth_tree);
        System.out.println("Depth First Search of Binary Search Tree : ");
        d.Preorder(d.root);
        System.out.println("\nBreadth First Search of Binary Search Tree : ");
        d.BFS(d.root);
        

        System.out.println("\n\nMirror of Binary Tree : ");
        d.Mirror(d.root);
        System.out.println("\nBreadth First Search of Binary Search Tree : ");
        d.BFS(d.root);
        System.out.println("\nInorder Traversal of Binary Tree : ");
        d.Inorder(d.root);
        System.out.println("\nPost Order");
        d.Postorder(d.root);

        System.out.print("\nNumber of Leaf Node in Binary Tree : ");
        int leavs=d.leavs_count(d.root);
        System.out.println(leavs);

        System.out.print("\nNumber of Non-Leaf Node in Binary Tree : ");
        int nonleaf=d.Non_leaf(d.root);
        System.out.println(nonleaf);

        System.out.print("\nNumber of Node which have Both Left and Right Child : ");
        int bothnode=d.Both_Node(d.root);
        System.out.println(bothnode);

        System.out.print("\nTotal Number of Element in Tree : ");
        int total_element=d.Count_Element();
        System.out.print(total_element);
        sc.close();
    }
}
