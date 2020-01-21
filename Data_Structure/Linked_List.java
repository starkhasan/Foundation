//program for the linked list using all operation of linked list
import java.util.Scanner;
class demo
{
	Node head;
	Node sorted;
	static class Node
	{
		int data;
		Node next;
		Node(int t)
		{
			data=t;
			next=null;
		}
	}

	public void push(int new_data)
	{
		if(head==null)
		{
			head=new Node(new_data);
			return;
		}
		Node current=head;
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=new Node(new_data);
	}

	public void reverse()
	{
		
		Node temp=head;
		Node prev=null;
		Node next=null;
		
		while(temp!=null)
		{
			next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
		}

		head=prev;
	}

	public void search_node(int data)
	{
		
		int new_size_list=get_size();
		if(data==1)
		{
			Node temp=head;
			temp=temp.next;
			head=temp;
		}
		else if(data==new_size_list)
		{
			Node temp=head;
        	for(;temp.next.next!=null;temp=temp.next)
        	{}
        	temp.next=null;
		}
		else
		{
			Node temp=head;
			for(int i=1;i<data-1;i++)
			{
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}


	}
	public void delete_Node_data_part(Node prev)
	{
		int position=0;
		Node temp1=head;
		for(;temp1.next!=null;temp1=temp1.next)
		{
			position++;
			if(prev==temp1)
			{
				search_node(position);
			}
		}
	}
	public void delete_Node_data(int data)
	{
		Node prev=null;
		Node temp=head;
		for(;temp.next!=null;temp=temp.next)
		{
			if(temp.data==data)
			{
				prev=temp;
				delete_Node_data_part(prev);
			}
		}
		
    }
    
    public void delete_last_node()
    {
        Node temp=head;
        for(;temp.next.next!=null;temp=temp.next)
        {}
        temp.next=null;
	}
	
	public void delete_first_node()
	{
		Node temp=head;
		temp=temp.next;
		head=temp;
	}

	public void sorted(Node headref)
	{
		sorted=null;
		Node current=headref;
		while(current!=null)
		{
			Node new_node=current.next;
			sorted_list(current);
			current=new_node;
		}
		head=sorted;

	}

	public void sorted_list(Node new_next)
	{
		if(sorted==null || sorted.data>=new_next.data)//smaller data
		{
			new_next.next=sorted;
			sorted=new_next;
		}
		else
		{
			Node current=sorted;
			while(current.next!=null && current.next.data<new_next.data)//bigger data
			{
				current=current.next;
			}
			new_next.next=current.next;
			current.next=new_next;

		}
	}
    public int get_size()
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }

        return count;
	}
	
	public void add_first(int data)
	{
		Node temp=new Node(data);
		temp.next=head;
		head=temp;
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

		Scanner sc=new Scanner(System.in);
		demo list=new demo();
		//list.display();
		char ch;
		int choice=0;
		do
		{
			System.out.println("\nWhich of Following operation you want to perform :");
			System.out.println("1. 	Additing New Element in List : ");
			System.out.println("2. 	Revers List : ");
			System.out.println("3. 	Deletion Last Element : ");
			System.out.println("4. 	Deletion Particular Position : ");
			System.out.println("5. 	Deletion Particular Element : ");
			System.out.println("6. 	Get Size of List : ");
			System.out.println("7. 	Deletion First Element : ");
			System.out.println("8. 	Show Linked List : ");
			System.out.println("9. 	Add at First : ");
			System.out.println("10. 	Add at Last : ");
			System.out.println("11. 	Sorting List : ");
            System.out.println("\nChoose Your Option ");
			choice=sc.nextInt();
			switch(choice)
			{

				case 1:
                System.out.println("How nuch Element Do u want to insert : ");
                int list_size=sc.nextInt();
                System.out.println("Enter Element in List : ");
                for(int i=0;i<list_size;i++)
				{
					list.push(sc.nextInt());
				}
                System.out.println("\nList");
                list.display();
                break;
                case 2:
                System.out.println("\nBefore Reverse");
                list.display();
                System.out.println("\nAfter Reverse");
			    list.reverse();
				list.display();
				list.reverse();
                break;
                case 3:
                list.delete_last_node();
                System.out.println("\nAfter Deletion");
                list.display();
                break;
                case 4:
                System.out.println();
			    System.out.println("\nEnter Position for Deletion : ");
			    int del_node=sc.nextInt();
                list.search_node(del_node);
                System.out.println("\nNew List");
                list.display();
                break;    
                case 5:
                System.out.println("Which Data do u want to delete : ");
			    int data=sc.nextInt();
			    list.delete_Node_data(data);
                list.display();    
                break;
                case 6:
                int new_size=list.get_size();
                System.out.println("Size of List = "+new_size);
				break;
				case 7:
				list.delete_first_node();
				System.out.println("\nAfter Seletion");
				list.display();
				break;
				case 8:
				System.out.println("\nLinked List");
				list.display();
				break;
				case 9:
				System.out.println("\nEnter data : ");
				int add_first1=sc.nextInt();
				list.add_first(add_first1);
				list.display();
				break;
				case 10:
				System.out.println("\nEnter data : ");
				int add_first2=sc.nextInt();
				list.push(add_first2);
				list.display();
				break;
				case 11:
				System.out.println("\nSorted Linked List");
				list.sorted(list.head);
				list.display();
				break;
                default:
                System.out.println("Please Enter Valid Input : ");
                break;

            }
            
			System.out.println("\n\nWANT TO CONTINUE... Y/N");
	        ch=sc.next().charAt(0);
	        if(ch=='n' || ch=='N')
	        System.out.println("\n\t--: Thank You :--");

        }while(ch=='Y' || ch=='y');
        
        sc.close();
	}

}