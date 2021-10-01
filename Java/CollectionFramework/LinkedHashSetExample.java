import java.io.PrintWriter;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    /**
     * HashSet class does not allow duplicate value
     * LinkedHashSet extends HashSet
     * it maintain the order of insertion
     */
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        linkedHashSet.add(12);
        linkedHashSet.add(12);
        linkedHashSet.add(13);
        linkedHashSet.add(15);
        linkedHashSet.add(15);
        linkedHashSet.add(17);
        linkedHashSet.add(18);
        linkedHashSet.add(19);

        for(var item : linkedHashSet){
            pw.println(item);
        }
        pw.println();
    }
}
