import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class AddTwoNumber {
    static Node insert(Node head,int data){
        if(head == null){
          head = new Node(data);
        }else{
          Node current = head;
          while(current.next!=null){
            current = current.next;
          }
          current.next = new Node(data);
        }
        return head;
    }
    
      //Printing the Result in LinkedList
      static void printList(Node head){
        Node temp = head;
        while(temp!=null){
          System.out.print(temp.data+" ");
          temp = temp.next;
        }
      }
    
      static Node addList(Node head1,Node head2){
        int carry = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        Node result = null;
        while(temp1!=null || temp2!=null || carry>0){
          if(temp1!=null){
            carry+=temp1.data;
            temp1 = temp1.next;
          }
    
          if(temp2!=null){
            carry+=temp2.data;
            temp2 = temp2.next;
          }
          int data = carry%10;
          result = insert(result,data);
          carry = carry/10;
        }
        return result;
      }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String inputFirst = "";
        String inputSecond = "";
        boolean isFirst = true;
        Node head1 = null;
        Node head2 = null;
        int data = 0;
        while((buffer.readLine())!=null){
        if(isFirst){
            isFirst = false;
            inputFirst = buffer.readLine();
        }else
            inputSecond = buffer.readLine();
        }

        //Insert in First Element
        String[] strArFirst = inputFirst.split(" ");
        for(int i=0;i<strArFirst.length;i++){
        data = Integer.parseInt(strArFirst[i]);
        head1 = insert(head1, data);
        }

        //Insert in second List
        String[] strArSecond = inputSecond.split(" ");
        for(int i=0;i<strArSecond.length;i++){
        data = Integer.parseInt(strArSecond[i]);
        head2 = insert(head2,data);
        }

        //OPeration
        Node result = addList(head1, head2);
        System.out.println("After Adding Two LinkedList : ");
        printList(result);
        buffer.close();
    }
}
