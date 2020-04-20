//implementation of Queue
import java.util.Scanner;
class demo
{
    //Implemented by Ali Hasan
	Node head;
	Node tail;
	static class Node
	{
		int data;
		Node next;
		Node(int t)
		{
			data=t;
		}
	}

	public void isEmpty()
	{
		if(head==null)
		{
			System.out.println("Queue is Empty");
		}
		else
		{
			System.out.println("Queue is Not Empty");
		}
	}

	public void add(int data)
	{
		Node new_node=new Node(data);
		if(tail!=null)
		{
			tail.next=new_node;
		}
		tail=new_node;
		if(head==null)
		{
			head=new_node;
		}

	}

	public int remove()
	{
		int data=head.data;
		head=head.next;
		if(head==null)
		{
			tail=null;
		}
		return data;
	}

	public void show()
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
		System.out.println("Enter Size : ");
		int size=sc.nextInt();
		System.out.println("Enter Element in Queue");
		for(int i=0;i<size;i++)
		{
			d.add(sc.nextInt());
		}
		d.isEmpty();
        d.show();
        
		int data=d.remove();
        System.out.print("\nData Removed from Queue : "+data);
        System.out.println("\n\nQueue After Deletion First Element ");
		d.show();
		sc.close();

	}
}