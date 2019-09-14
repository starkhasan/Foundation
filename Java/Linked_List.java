import java.util.Scanner;
class demo
{
    Node head;
    static class Node
    {
        Node next;
        int data;
        Node(int data)
        {
            this.data=data;
            next=null;
        }
    }

    public void insert(int data)
    {
        if(head==null)
        {
            head=new Node(data);
            return;
        }
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=new Node(data);
    }

    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String [] args)
    {
        demo d=new demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of Linked List : ");
        int list_size=sc.nextInt();
        System.out.println("Enter Element in the Linked List : ");
        for(int i=0;i<list_size;i++)
        {
            d.insert(sc.nextInt());
        }

        d.display();
        sc.close();
    }
}