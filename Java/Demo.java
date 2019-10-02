import java.util.Scanner;
class demo
{
    Node head;
    static class Node
    {
        int data;
        Node next;
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
           
            System.out.print(temp.data);
            if(temp.next!=null)
            {
                System.out.print(" -> ");
            }
            temp=temp.next;
            
        }
    }

    public int length()
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
    public void reverse()
    {
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
    }

    public void palindrome()
    {
        Node temp=head;
        String old="";
        while(temp!=null)
        {
            old=old+(String.valueOf(temp.data));
            temp=temp.next;
        }

        reverse();

        Node temp1=head;
        String new_str="";
        while(temp1!=null)
        {
            new_str=new_str+(String.valueOf(temp1.data));
            temp1=temp1.next;
        }


        if(old.equals(new_str))
        {
            System.out.println("\nLinked List is Palindrome");
        }
        else
        {
            System.out.println("\nLinked List is not Palindrome");
        }

        reverse();

    }

    public void sorting()
    {
        Node temp=head;
        int size=0;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }

        int a[]=new int[size];
        temp=head;
        for(int i=0;i<size;i++)
        {
            a[i]=temp.data;
            temp=temp.next;
        }

        System.out.println("\nElement in Array : ");
        for(int i=0;i<size;i++)
        {
            System.out.print(a[i]+" ");
        }

        System.out.println("\nSorted Array : ");
        int key=0;
        for(int j=1;j<size;j++)
        {
            key=a[j];
            int i=j-1;
            while(i>=0 && a[i]>key)
            {
                a[i+1]=a[i];
                i-=1;
            }
            a[i+1]=key;

        }

        for(int i=0;i<size;i++)
        {
            System.out.print(a[i]+" ");
        }

    }

    public void delete_first()
    {
        Node temp=head;
        temp=temp.next;
        head=temp;
        System.out.println("\nDelete First Node : ");
        display();
        length();
    }

    public void delete_last()
    {
        Node temp=head;
        for(;temp.next.next!=null;temp=temp.next)
        {}
        temp.next=null;
        System.out.println("\nDelete From Last : ");
        display();
        length();
    }
    public void search_node(int data)
	{
		
		int new_size_list=length();
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
        
        display();
		
    }

    public boolean contain()
    {
        boolean bool=false;
        Node temp=head;
        Node temp1=head;
        int count=0;
        for(;temp!=null;temp=temp.next)
        {
            for(;temp1!=null;temp1=temp1.next)
            {
                if(temp.data==temp1.data)
                {
                    count++;
                }
                if(count>1)
                {
                    bool=true;
                    break;
                }
            }
            count=0;
        }
        if(count>1)
        return bool;
        else
        return bool;
    }

    public void available(int avail)
    {
        Node temp=head;
        int count=0;
        while(temp!=null)
        {
            if(temp.data==avail)
            {
                count++;
            }
            temp=temp.next;
        }


        if(count>0)
        {
            System.out.println("\n"+avail+" is Found in the Linked List "+count+" times .");
        }
        else
        {
            System.out.println("Sorry "+avail+" is not Found in the Linked List : ");
        }

    }

    public static void main(String [] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the linked list : ");
        int list_size=sc.nextInt();
        System.out.println("Enter the Element in Linked List : ");
        demo d=new demo();

        for(int i=0;i<list_size;i++)
        {
            d.insert(sc.nextInt());
        }

        System.out.println("\nLinked List : ");
        d.display();
        int linked_list_size=d.length();
        System.out.println("\nSize of the Linked List = "+linked_list_size);
        d.sorting();
        d.palindrome();
        d.delete_first();
        d.delete_last();
        System.out.println("\nEnter the Element to Delete : ");
        int ele=sc.nextInt();
        d.delete_Node_data(ele);
        boolean b=d.contain();
        if(b)
        System.out.println("\n\nLinked List contain Duplicate Element ");
        else
        System.out.println("\n\nLinked List doesn't contain Duplicate Element ");
        System.out.print("\nEnter Number for Checking the Avalability : ");
        int avail=sc.nextInt();
        d.available(avail);
        sc.close();

    }
}

