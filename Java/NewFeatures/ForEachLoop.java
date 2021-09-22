import java.util.*;
public class ForEachLoop {
    public static void main(String[] args) {
        List<String> listNames = new ArrayList<String>();
        listNames.add("India");
        listNames.add("Australia");
        listNames.add("England");
        listNames.add("New Zealand");
        listNames.add("South Africa");
        listNames.add("Sri Lanka");
        listNames.add("Pakistan");
        listNames.add("Bangladesh");
        listNames.add("West Indies");
        listNames.add("Afghanistan");
        listNames.add("Ireland");
        System.out.println("------------Iterating by passing lambda expression--------------");  
        listNames.forEach(names -> System.out.println(names));
        System.out.println("------------Iterating by passing method reference---------------");
        listNames.forEach(System.out::println);
    }
}
