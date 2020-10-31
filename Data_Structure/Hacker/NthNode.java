import java.util.*;
import java.io.*;
public class NthNode {
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
    static int getNthFromLast(Node head, int n){
    	int list_size = getSize(head);
    	int result = 0;
    	if(n > list_size){
    	    result = -1;
    	}else{
    	    Node temp = head;
    	    int k = list_size - n;
    	    int count = 0;
    	    while(count<=k){
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
        int n = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                input = buffer.readLine();
            }else{
                n = Integer.parseInt(buffer.readLine());
            }
        }
        String[] strAr = input.split(" ");
        for(int i=0;i<strAr.length;i++){
            head = insert(head,Integer.parseInt(strAr[i]));
        }
        System.out.println(getNthFromLast(head,n));
        buffer.close();
    }
}
