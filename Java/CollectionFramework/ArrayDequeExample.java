import java.util.*;
import java.io.*;
public class ArrayDequeExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);

    public static void printDeque(Deque<Integer> deque){
        for(var item : deque){
            pw.println(item);
        }
    }

    public static void popingDeque(Deque<Integer> deque){
        while(!deque.isEmpty()){
            pw.println(deque.pop());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);
        deque.add(50);
        printDeque(deque);
        deque.addFirst(100);
        deque.addLast(200);
        pw.println("After Adding First and Last Element ");
        printDeque(deque);
        pw.println("Remove First Element  = "+deque.pollFirst());
        pw.println("\nRemove Last Element = "+deque.pollLast());
        pw.println("\nAfter Removing First and Last Element");
        printDeque(deque);
        deque.push(420);
        pw.println("\nAfter Pusing First in Deque");
        printDeque(deque);
        pw.println("\nPoping Event Element of Stack");
        popingDeque(deque);
        if(deque.isEmpty())
            pw.println("\nDeque is Empty");
        else
            pw.println("\nDeque is not Empty");
    }
}
