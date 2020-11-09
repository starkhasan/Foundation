package LinkedList;
//Checking the Loop in Doubly Linked List
import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class Cycle_in_LinkedList{

    public Node insert(Node head,int data){
        if(head==null)
            head = new Node(data);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
        }
        return head;
    }

    public void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public void makeloop(Node head,int position){
        int count=1;
        while(count<position){
            temp=temp.next;
            count++;
        }
        Node current=temp;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=current;
    }

    public boolean containloop(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        Node head = null;
        Cycle_in_LinkedList d = new Cycle_in_LinkedList();
        System.out.println("Enter the Size of the list : ");
        int list_size=sc.nextInt();
        System.out.println("Enter the Element in Linked List : ");
        for(int i=0;i<list_size;i++)
            head = d.insert(head,sc.nextInt());
        d.display(head);
        System.out.println("Enter the Position for Making the Loop : ");
        int pos=sc.nextInt();
        d.makeloop(head,pos);
        boolean bool = d.containloop();
        String result = bool : "Yes Linked List Contain Loop : " ? "No Linked List Doesn;t Contain Loop : ";
        System.out.println(result);
        sc.close();
    }
}
