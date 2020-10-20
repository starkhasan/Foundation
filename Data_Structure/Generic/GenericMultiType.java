class TwoGen<T,V>{
    T obj1;
    V obj2;
    TwoGen(T o1,V o2){
        obj1 = o1;
        obj2 = o2;
    }

    void showTypes(){
        System.out.println("Type of T is "+obj1.getClass().getName());
        System.out.println("Type of V is "+obj2.getClass().getName());
    }

    T getob1(){
        return obj1;
    }

    V getob2(){
        return obj2;
    }
}
public class GenericMultiType {
    public static void main(String[] args) {
        TwoGen<Integer,String> tgObj = new TwoGen<>(88,"Ali Hasan");
        tgObj.showTypes();
        int v = tgObj.getob1();
        System.out.println("value = "+v);
        String str = tgObj.getob2();
        System.out.println("value = "+str);
    }
}
