//Program for leap year
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class Demo{
    static Node insert(Node head,int data){
        if(head==null)
            head = new Node(data);
        else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    static Node insertAtLast(Node head,int data){
        Node temp = head;
        Node newNode = new Node(data);
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) throws IOException{
        Node head = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }       
        for(int i=0;i<input.split(" ").length;i++){
            head = insert(head,Integer.parseInt(input.split(" ")[i]));
        }
        print(head);
        System.out.println("\nEnter Data");
        int temp = sc.nextInt();
        head = insertAtLast(head,temp);
        print(head);
        buffer.close();
        sc.close();
    }
}