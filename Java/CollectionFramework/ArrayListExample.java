import java.util.*;
import java.io.*;
public class ArrayListExample {
    /**
     * It can Store duplicate value
     * it can not store null value
     */
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        pw.println("Size of the ArrayList = "+list.size());
        list.forEach(item -> pw.print(item+" "));
        pw.println();
    }
}
