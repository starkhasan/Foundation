//implementation of Doubly Linked List
package LinkedList;
import java.util.Scanner;
class demo
{
	Node head;
	static class Node
	{
		Node next;
		Node prev;
		int data;
		Node(int data)
		{
			this.data=data;
			prev=null;
			next=null;
		}
	}

	public void insert(int data)
	{
		if(head==null)
		{
			head=new Node(data);
			head.prev=null;
			return;
		}
		Node current=head;
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=new Node(data);
		current.next.prev=current;
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

	public void add_last(int data)
	{
		Node temp=head;
		for(;temp.next!=null;temp=temp.next)
		{}

		Node new_node=new Node(data);
		temp.next=new_node;
		new_node.prev=temp;
	}
	public static void main(String [] args){
		
		Scanner sc=new Scanner(System.in);
		demo d=new demo();
		System.out.println("Enter Size : ");
		int list_size=sc.nextInt();
		System.out.println("Enter Element in List : ");
		for(int i=0;i<list_size;i++){
			d.insert(sc.nextInt());
		}
		d.display();
		System.out.println("Enter Last Element : ");
		int last_ele=sc.nextInt();
		d.add_last(last_ele);
		d.display();
		sc.close();
	}
}