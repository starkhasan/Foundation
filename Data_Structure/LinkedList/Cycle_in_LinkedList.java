package LinkedList;
//Checking the Loop in Doubly Linked List
import java.util.Scanner;
class demo
{
    Node head;
    class Node
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

    public void makeloop(int position)
    {
        int count=1;
        Node temp=head;
        while(count<position)
        {
            temp=temp.next;
            count++;
        }

        Node current=temp;

        while(temp.next!=null)
        {
            temp=temp.next;
        }

        temp.next=current;

    }

    public boolean containloop()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                return true;
            }
        }


        return false;
    }

    public static void main(String [] args)
    {

        Scanner sc=new Scanner(System.in);
        demo d=new demo();
        System.out.println("Enter the Size of the list : ");
        int list_size=sc.nextInt();
        System.out.println("Enter the Element in Linked List : ");
        for(int i=0;i<list_size;i++)
        {
            d.insert(sc.nextInt());
        }
        d.display();

        System.out.println("Enter the Position for Making the Loop : ");
        int pos=sc.nextInt();
        d.makeloop(pos);
        boolean bool=d.containloop();
        if(bool)
        {
            System.out.println("Yes Linked List Contain Loop : ");
        }
        else
        {
            System.out.println("No Linked List Doesn;t Contain Loop : ");
        }

        sc.close();

    }
}
