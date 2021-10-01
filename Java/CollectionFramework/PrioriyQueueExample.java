import java.util.*;
import java.io.*;
public class PriorityQueueExample{
  private static final PrintWriter pw = new PrintWriter(System.out,true);
  /**
   * In PrioriyQueue the only Guarantee  you have the head is the lowest( or greatest depending on your comparison)
   * The internal structure is not necessarily a sorted list. Actually in java it's heap
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException{
    PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
    priorityQueue.add("Star");
    priorityQueue.add("Moon");
    priorityQueue.add("Galexy");
    priorityQueue.add("Earth");
    priorityQueue.add("Jupitor");
    priorityQueue.add("Venus");

    for(var item : priorityQueue){
      pw.println(item);
    }

    PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<Integer>();
    priorityQueue2.add(23);
    priorityQueue2.add(43);
    priorityQueue2.add(12);
    priorityQueue2.add(21);
    priorityQueue2.add(10);
    priorityQueue2.add(45);
    priorityQueue2.add(37);

    while(!priorityQueue2.isEmpty()){
      pw.println(priorityQueue2.poll());
    }
    pw.println();
  }
}
