//Linked list Implementation for Palindrome of a number
import java.util.*;
class demo
{
	Node head;
	static class Node
	{
		Node next;
		char data;
		Node(char data)
		{
			this.data=data;
			next=null;
		}
	}
	public void insert(char data)
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
	public void reverse(String new_str)
	{
		String new_str1="";
		Node temp=head;
		Node current=head;
		Node prev=null;
		while(temp!=null)
		{
			current=temp.next;
			temp.next=prev;
			prev=temp;
			temp=current;
		}
		head=prev;

		Node temp1=head;
		while(temp1!=null)
		{
			new_str1=new_str1+temp1.data;
			temp1=temp1.next;
		}

		if(new_str.equals(new_str1))
			System.out.println("\nString is Palindrome");
		else
			System.out.println("\nString is not Palindrome");
	}
	public static void main(String [] args)
	{
		demo d=new demo();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String : ");
		String str=sc.nextLine();
		String str1[]=str.split(" ");
		int new_length=str1.length;
		for(String word:str1)
		{
			char chr[]=word.toCharArray();
			for(int i=0;i<chr.length;i++)
			{
				d.insert(chr[i]);
			}
		}
		//d.display();
		String new_str="";
		for(int i=0;i<new_length;i++)
			new_str+=str1[i];
		d.reverse(new_str);
		sc.close();
	}
}
