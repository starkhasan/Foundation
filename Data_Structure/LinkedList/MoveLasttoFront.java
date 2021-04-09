import java.io.*;
import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class MoveLasttoFront{
    static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
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

    static Node removelast(Node head){
        Node temp = head;
        Node tempSec = head;
        while(temp.next!=null){
            tempSec = temp;
            temp = temp.next;
        }
        tempSec.next = null;
        temp.next = head;
        head =  temp;
        return head;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        Node head = null;
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        for(String str:input.split(" ")){
            head = insert(head, Integer.parseInt(str));
        }
        print(head);      
        System.out.println("\nMove Last Node to Front");
        Node newNode = removelast(head);
        print(newNode); 
        buffer.close();
    }
}