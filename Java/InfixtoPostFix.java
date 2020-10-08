import java.util.Scanner;
public class InfixtoPostFix {
    static String postfix="";
    Node head;
    class Node{
        Node next;
        String data;
        Node(String data){
            this.data = data;
            next = null;
        }
    }
    
    public void push(String data){
        if(head == null){
            head = new Node(data);
            return;
        }else{
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void pop(){
        Node temp = head;
        if(temp.data.equals("{") || temp.data.equals("[") || temp.data.equals("(") || temp.data.equals("(")){}else{
            postfix = postfix + String.valueOf(temp.data);
        }
        if(temp!=null){
            temp = temp.next;
        }
        head = temp;
    }
    
    public static void main (String[] args) {
        InfixtoPostFix main = new InfixtoPostFix();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Infix Operator");
        String infix = sc.nextLine();
        for(int i=0;i<infix.length();i++){
            if(String.valueOf(infix.charAt(i)).equals("{") || String.valueOf(infix.charAt(i)).equals("[") || String.valueOf(infix.charAt(i)).equals("(") || String.valueOf(infix.charAt(i)).equals("+") || String.valueOf(infix.charAt(i)).equals("-") || String.valueOf(infix.charAt(i)).equals("*") || String.valueOf(infix.charAt(i)).equals("/") || String.valueOf(infix.charAt(i)).equals("^")){
                main.push(String.valueOf(infix.charAt(i)));
            }else if(String.valueOf(infix.charAt(i)).equals("}") || String.valueOf(infix.charAt(i)).equals("]") || String.valueOf(infix.charAt(i)).equals(")")){
                main.pop();
            }else{
                postfix = postfix + String.valueOf(infix.charAt(i));
            }
        }
        System.out.println("PostFix Operator = "+postfix);
        sc.close();   
    }
}