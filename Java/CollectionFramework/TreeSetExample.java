import java.util.*;
import java.io.*;
public class TreeSetExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(19);
        treeSet.add(15);
        treeSet.add(13);
        treeSet.add(15);
        treeSet.add(12);
        treeSet.add(17);
        treeSet.add(18);
        treeSet.add(12);

        for(var item : treeSet){
            pw.println(item);
        }
        pw.println();        
    }
}
