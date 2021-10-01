import java.util.*;
import java.io.*;
public class TreeMapExample {
    /**
     * TreeMap class extends AbstractMap and implements the NavigableMap interface
     * It create mapsstored in tree structure
     * TreeMap element will be sorted in ascending key order
     */
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        treeMap.put("India", 20);
        treeMap.put("Australia", 30);
        treeMap.put("Indonesia", 40);
        treeMap.put("Afghanistan", 10);
        treeMap.put("SriLanka", 50);
        treeMap.put("Bangladesh", 70);
        treeMap.put("Singapore", 90);
        treeMap.put("London", 60);

        for(Map.Entry<String,Integer> item : treeMap.entrySet()){
            pw.println(item.getKey()+" "+item.getValue());
        }

        //Iterate only over keys
        //Set<T> keys = treeMap.keySet()
        pw.println("\nIterate only over keys");
        for(var item : treeMap.keySet()){
            pw.println(item);
        }

        //Iterate only over values
        //Collection<T> values = treeMap.values()
        pw.println("\nIterate only over values");
        for(var item : treeMap.values()){
            pw.println(item);
        }
        pw.println();
    }   
}
