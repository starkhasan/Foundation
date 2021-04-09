import java.io.*;
import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class IntersectionPoint {
    static int listLength(Node head){
        Node temp = head;
        int counter = 0;
        while(temp!=null){
            counter++;
            temp = temp.next;
        }
        return counter;
    }

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

    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static int getDiffStep(Node headFirst,Node headSecond){
        //Applicable only when length of first LinkedList is greater than length of Second LinkedList
        int c1 = listLength(headFirst);
        int c2 = listLength(headSecond);
        int diff = c1 - c2;
        Node tempFirst = headFirst;
        Node tempSecond = headSecond;
        for(int i=0;i<diff;i++){
            tempFirst = tempFirst.next;
        }
        int commanElement = -1;
        while(tempFirst!=null && tempSecond!=null){
            if(tempFirst.data == tempSecond.data){
                commanElement = tempFirst.data;
                break;
            }
            tempFirst = tempFirst.next;
            tempSecond = tempSecond.next;
        }

        return commanElement;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String first = "";
        String second = "";
        boolean isFirst = true;
        Node headFirst = null;
        Node headSecond = null;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                first = buffer.readLine();
            }else{
                second = buffer.readLine();
            }
        }
        for(String str:first.split(" ")){
            headFirst = insert(headFirst, Integer.parseInt(str));
        }

        for(String str:second.split(" ")){
            headSecond = insert(headSecond, Integer.parseInt(str));
        }
        System.out.println(getDiffStep(headFirst,headSecond));
        buffer.close();
    }   
}
