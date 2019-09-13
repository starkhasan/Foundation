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

    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of Linked List : ");
        int size_tree=sc.nextInt();
        System.out.println("Enter Element in Linked List : ");
        demo d=new demo();

    }
}