package Stack;
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

        }
    }

    public void insert(int data)
    {
        Node new_node=new Node(data);
        new_node.next=head;
        head=new_node;
    }

    //Display the content of the Stack
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    //Size of the stack
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

    //Summation of All Element of Stack
    public void Element_Summation()
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count+=temp.data;
            temp=temp.next;
        }

        System.out.println("\nSummation of Stack Element = "+count);
    }

    //Finding the Greatest Element of Stack
    public void find_greatest()
    {
        int great=0;
        Node temp=head;
        while(temp!=null)
        {
            if(great<temp.data)
            {
                great=temp.data;
            }
            temp=temp.next;
        }

        System.out.println("Greatest NUmber = "+great);
    }

    //find smallest number of stack
    public void smallest()
    {
        Node temp=head;
        int smallest=temp.data;
        while(temp!=null)
        {
            if(smallest>temp.data)
            {
                smallest=temp.data;
            }

            temp=temp.next;
        }

        System.out.println("Smallest Number = "+smallest);
    }
    
    public static void main(String[] args)
    {
        demo d=new demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Stack : ");
        int stack_size=sc.nextInt();
        System.out.println("Enter Element in Stack : ");
        for(int i=0;i<stack_size;i++)
        {
            d.insert(sc.nextInt());
        }
        d.display();
        int size=d.get_size();
        System.out.println("\nSize of Stack = "+size);
        d.Element_Summation();
        //Calling find_greatest method
        d.find_greatest();
        d.smallest();

    }
}