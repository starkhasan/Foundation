import java.io.*;
import java.util.*;
public class HashMapExample {
    /**
     * HashMap does not maintain the insertion order because it store it in HashTable
     */
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("India", 20);
        hashMap.put("Australia", 30);
        hashMap.put("Indonesia", 40);
        hashMap.put("Afghanistan", 10);
        hashMap.put("SriLanka", 50);
        hashMap.put("Bangladesh", 70);
        hashMap.put("Singapore", 90);
        hashMap.put("London", 60);

        for(Map.Entry<String,Integer> item : hashMap.entrySet()){
            pw.println(item.getKey()+" "+item.getValue());
        }

        //Iterate only over keys
        //Set<T> keys = hashMap.keySet()
        pw.println("\nIterate only over keys");
        for(var item : hashMap.keySet()){
            pw.println(item);
        }

        //Iterate only over values
        //Collection<T> values = hashMap.values()
        pw.println("\nIterate only over values");
        for(var item : hashMap.values()){
            pw.println(item);
        }
        pw.println();
    }
}
