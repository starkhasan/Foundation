import java.util.HashSet;
public class HashSetExample {
    String name;
    int age;
    HashSetExample(String name,int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        var obj1 = new HashSetExample("Ali",20);
        var obj2 = new HashSetExample("Ali",20);
        HashSet<HashSetExample> hashSet = new HashSet<HashSetExample>();
        System.out.println(obj1.hashCode()+" "+obj2.hashCode());
        hashSet.add(obj1);
        hashSet.add(obj2);
        System.out.println(hashSet.size());
    }
}
