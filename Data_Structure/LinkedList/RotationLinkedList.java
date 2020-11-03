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
public class RotationLinkedList {
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

    static void printLinkedList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    static int listsize(Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    static Node LeftRotation(Node head,int rotation){
        if(head == null || listsize(head) == 1){
            return head;
        }else{
            int count = 0;
            Node temp = head;
            while(count<rotation){
                Node newNode = temp;
                Node newHead = temp.next;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = null;
                temp = newHead;
                count++;
            }
            head = temp;
            return head;
        }
    }

    static Node RightRotation(Node head,int rotation){
        if(head == null || listsize(head) == 1){
            return head;
        }else{
            int count = 0;
            Node temp = head;
            while(count<rotation){
                Node newHead = temp;
                Node last = null;
                while(temp!=null){
                    if(temp.next.next==null){
                        last = temp.next;
                        temp.next= null;
                        break;
                    }
                    temp = temp.next;
                }
                last.next = newHead;
                temp = last;
                count++;
            }
            head = temp;
            return head;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        Node head = null;
        String input = "";
        int rotation  = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                input = buffer.readLine();
            }else{
                rotation = Integer.parseInt(buffer.readLine());
            }
        }
        String[] strAr = input.split(" ");
        for(int i=0;i<strAr.length;i++){
            head = insert(head,Integer.parseInt(strAr[i]));
        }
        printLinkedList(head);
        System.out.println("\nPerforming Left Rotation : ");
        head = LeftRotation(head,rotation);
        printLinkedList(head);
        System.out.println("\nPerforming Right Rotation : ");
        head = RightRotation(head,rotation);
        printLinkedList(head);
        buffer.close();
    }   
}
