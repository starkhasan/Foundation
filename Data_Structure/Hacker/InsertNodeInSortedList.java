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
public class InsertNodeInSortedList{
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
    static Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        boolean isFirst = true;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(isFirst){
                isFirst = false;
                if(data < temp.data){
                    newNode.next = temp;
                    temp = newNode;
                    head = temp;
                    break;
                }
            }else{
                if(data >= prev.data && data <= temp.data){
                    newNode.next = temp;
                    prev.next = newNode;
                    break;
                }else if(temp.next == null && data >= temp.data){
                    temp.next = newNode;
                    newNode.next = null;
                    break;
                }
            }
            prev = temp;
            temp = temp.next;
        }
        return head;

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
        System.out.println("Enter Data ot insert : ");
        int data = sc.nextInt();
        root = sortedInsert(root,data);
        sc.close();
        buffer.close();
        
    }
}