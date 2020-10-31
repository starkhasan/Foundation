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
public class ListMiddleElement{
    static Node insert(Node head,int data){
        if(head==null){
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
    static int getSize(Node head){
        Node temp = head;
        int size = 0;
        while(temp!=null){
            size+=1;
            temp = temp.next;
        }
        return size;
    }
    static int getMiddle(Node head){
        Node temp = head;
        int result = 0;
        int listSize = getSize(head);
        if(listSize == 1)
            result = temp.data;
        else{
            listSize = listSize/2;
            int count = 0;
            while(count<=listSize){
                result = temp.data;
                temp = temp.next;
                count++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        Node head = null;
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for(int i=0;i<strAr.length;i++){
            head = insert(head,Integer.parseInt(strAr[i]));
        }
        System.out.println(getMiddle(head));
        buffer.close();
    }
}