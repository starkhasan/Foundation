import java.util.*;
import java.io.*;
public class LinkedHashMapExample {
    /**
     * LinkedHashMap extends HashMap
     * It maintains linked list to the entries in the map in the order in which they are inserted.
     * It maintain the Insertion Order
     */
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<String,Integer>();
        linkedHashMap.put("India", 20);
        linkedHashMap.put("Australia", 30);
        linkedHashMap.put("Indonesia", 40);
        linkedHashMap.put("Afghanistan", 10);
        linkedHashMap.put("SriLanka", 50);
        linkedHashMap.put("Bangladesh", 70);
        linkedHashMap.put("Singapore", 90);
        linkedHashMap.put("London", 60);

        for(Map.Entry<String,Integer> item : linkedHashMap.entrySet()){
            pw.println(item.getKey()+" "+item.getValue());
        }

        //Iterate only over keys
        //Set<T> keys = linkedHashMap.keySet()
        pw.println("\nIterate only over keys");
        for(var item : linkedHashMap.keySet()){
            pw.println(item);
        }

        //Iterate only over values
        //Collection<T> values = linkedHashMap.values()
        pw.println("\nIterate only over values");
        for(var item : linkedHashMap.values()){
            pw.println(item);
        }
        pw.println();
    }
}
