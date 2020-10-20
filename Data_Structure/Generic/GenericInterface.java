package Generic;
interface MinMax<T extends Comparable<T>>{
    T min();
    T max();
}
class MyClass<T extends Comparable<T>> implements MinMax<T>{

    T[] num;

    MyClass(T[] o){
        num = o;
    }

    @Override
    public T min() {
        T v = num[0];
        for(int i=0;i<num.length;i++){
            if(num[i].compareTo(v) < 0)
                v = num[i];
        }
        return v;
    }

    @Override
    public T max() {
        T v = num[0];
        for(int i=0;i<num.length;i++){
            if(num[i].compareTo(v) > 0)
                v = num[i];
        }
        return v;
    }

}
public class GenericInterface{
    public static void main(String[] args) {
        Integer[] intAr = {1,2,3,4,5,6,7};
        MyClass<Integer> obj = new MyClass<>(intAr);
        System.out.println("Minimum value = "+obj.min());
        System.out.println("Maximum value = "+obj.max());
    }
}
