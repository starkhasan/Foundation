//program for the linked list using all operation of linked list
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
class LinkedList{
	public Node insert(Node head,int data){
		if(head==null)
			head=new Node(data);
		else{
			Node current = head;
			while(current.next!=null){
				current = current.next;
			}
			current.next = new Node(data);
		}
		return head;
	}

	public Node reverse(Node head){
		Node temp=head;
		Node prev=null;
		Node next=null;
		while(temp!=null){
			next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
		}
		return prev;
	}

	public void search_node(Node head,int data){	
		int new_size_list=get_size(head);
		if(data==1){
			Node temp=head;
			temp=temp.next;
			head=temp;
		}
		else if(data==new_size_list){
			Node temp=head;
        	for(;temp.next.next!=null;temp=temp.next){}
        	temp.next=null;
		}
		else{
			Node temp=head;
			for(int i=1;i<data-1;i++)
				temp=temp.next;
			temp.next=temp.next.next;
		}
	}


	public void delete_Node_data_part(Node head,Node prev){
		int position=0;
		Node temp1=head;
		for(;temp1.next!=null;temp1=temp1.next){
			position++;
			if(prev==temp1)
				search_node(head,position);
		}
	}
	public boolean isAvailable(Node head,int data){
		boolean isPresent = false;
		Node temp = head;
		while(temp!=null){
			if(temp.data == data){
				isPresent = true;
				break;
			}
			temp = temp.next;
		}
		return isPresent;
	}
	public boolean delete_Node_data(Node head,int data){
		if(isAvailable(head,data)){
			Node prev=null;
			Node temp=head;
			for(;temp.next!=null;temp=temp.next){
				if(temp.data==data){
					prev=temp;
					delete_Node_data_part(head,prev);
				}
			}
			return true;
		}else{
			System.out.println(data+" doesn't exist in List.");
			return false;
		}
    }
    
    public void delete_last_node(Node head){
        Node temp=head;
        for(;temp.next.next!=null;temp=temp.next){}
        temp.next=null;
	}
	
	public Node delete_first_node(Node head){
		return head.next;
	}

	public Node sort_LinkedList(Node headref){
		Node sorted = null;
		Node current = headref;
		while(current!=null){
			Node newNode = current.next;
			sorted = sorted_list(current,sorted);
			current = newNode;
		}
		return sorted;
	}

	public Node sorted_list(Node new_next,Node sorted){
		if(sorted == null || sorted.data >= new_next.data){
			new_next.next=sorted;
			sorted=new_next;
		}else{
			Node current=sorted;
			while(current.next!=null && current.next.data<new_next.data){
				current=current.next;
			}
			new_next.next=current.next;
			current.next=new_next;
		}
		return sorted;
	}

    public int get_size(Node head){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
	}
	
	public Node add_first(Node head,int data){
		Node temp = new Node(data);
		temp.next = head;
		return temp;
	}

	Node add_at_Position(Node head,int position,int data){
		Node newNode = new Node(data);
		if(head == null || position == 0){
			newNode.next = head;
			head = newNode;
		}else{
			int listSize = get_size(head);
			if(position>=listSize){
				head = insert(head,data);
			}else{
				int start = 0;
				Node temp = head;
				while(start<position-1){
					temp = temp.next;
					start+=1;
				}
				if(temp.next == null){
					temp.next = newNode;
					newNode.next = null;
				}else{
					newNode.next = temp.next;
					temp.next = newNode;
				}
			}
		}
		return head;
	}

	boolean isPalindrome(Node head){
		String first = "";
		Node temp = head;
		while(temp!=null){
			first = first + String.valueOf(temp.data);
			temp = temp.next;
		}
		String second = "";
		head = reverse(head);
		temp = head;
		while(temp!=null){
			second = second + String.valueOf(temp.data);
			temp = temp.next;
		}
		head = reverse(head);
		if(first.equals(second))
			return true;
		return false;
	}

	public void display(Node head){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
    }
    
	public static void main(String [] args){
		Node head = null;
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int[] list_items = {5,3,7,1,4};
		for(int i=0;i<list_items.length;i++){
			head = list.insert(head,list_items[i]);
		}
		char ch;
		int choice=0;
		do{
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
			System.out.println("11. 	Add at Particular Position : ");
			System.out.println("12. 	Sorting List : ");
			System.out.println("13. 	Palindrome Linked List : ");
			System.out.println("\nLinked List : ");
			list.display(head);
            System.out.println("\nChoose Your Option ");
			choice=sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter Size of LinkedList : ");
					int list_size=sc.nextInt();
					System.out.println("Enter Element : ");
					for(int i=0;i<list_size;i++){
						head = list.insert(head,sc.nextInt());
					}
					System.out.println("\nList");
					list.display(head);
					break;
                case 2:
					System.out.println("\nBefore Reverse");
					list.display(head);
					System.out.println("\nAfter Reverse");
					head = list.reverse(head);
					list.display(head);
					head = list.reverse(head);
					break;
                case 3:
					list.delete_last_node(head);
					System.out.println("\nAfter Deletion");
					list.display(head);
					break;
                case 4:
					System.out.println();
					System.out.println("\nEnter Position for Deletion : ");
					int del_node=sc.nextInt();
					list.search_node(head,del_node);
					System.out.println("\nNew List");
					list.display(head);
					break;    
				case 5:
					list.display(head);
					System.out.println("\nWhich Element do u want to delete : ");
					int data=sc.nextInt();
					if(list.delete_Node_data(head,data))
						list.display(head);    
					break;
                case 6:
					int new_size=list.get_size(head);
					System.out.println("Size of List = "+new_size);
					break;
				case 7:
					head = list.delete_first_node(head);
					System.out.println("\nAfter Deletion");
					list.display(head);
					break;
				case 8:
					System.out.println("\nLinked List");
					list.display(head);
					break;
				case 9:
					System.out.println("\nEnter Element : ");
					head = list.add_first(head,sc.nextInt());
					list.display(head);
					break;
				case 10:
					System.out.println("\nEnter data : ");
					int add_first2=sc.nextInt();
					head = list.insert(head,add_first2);
					list.display(head);
					break;
				case 11:
					System.out.println("\nEnter Position to Append : ");
					int position = sc.nextInt();
					System.out.println("Enter Element to Append : ");
					int item = sc.nextInt();
					head = list.add_at_Position(head,position,item);
					list.display(head);
					break;
				case 12:
					System.out.println("\nSorted Linked List");
					head = list.sort_LinkedList(head);
					list.display(head);
					break;
				case 13:
					System.out.println("\nPalindrome Linked-List");
					if(list.isPalindrome(head))
						System.out.println("Yes Linked-List is Palindrome");
					else
						System.out.println("No Linked-List is not Palindrome");
					break;
                default:
					System.out.println("Please Enter Valid Input : ");
					break;
            }
			System.out.println("\nWant to continue... Y/N");
	        ch=sc.next().charAt(0);
	        if(ch=='n' || ch=='N')
	        	System.out.println("\n\t--: Thank You :--");
        }while(ch=='Y' || ch=='y');
        sc.close();
	}
}