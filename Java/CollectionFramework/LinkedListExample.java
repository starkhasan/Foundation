import java.util.*;
import java.io.*;
public class LinkedListExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        //Add Element to linked list
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("C");
        linkedList.add("Z");
        linkedList.add("A");

        pw.println("Original Content  = "+linkedList);

        linkedList.add(1, "A2");
        linkedList.remove("F");
        linkedList.remove(2);
        pw.println("Modified Content = "+linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        pw.println(linkedList.peekFirst());
        pw.println("Modified LinkedList = "+linkedList);
        pw.println();
    }
}
