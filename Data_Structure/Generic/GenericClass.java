package Generic;
class Gen<T>{
    T ob;
    Gen(T o){
        ob = o;
    }
    T getOb(){
        return ob;
    }
    void showType(){
        System.out.println("Type of T is "+ob.getClass().getName());
    }
}
public class GenericClass{
    public static void main(String[] args) {
        Gen<Integer> iob;
        iob = new Gen<Integer>(88);
        iob.showType();
        int v = iob.getOb();
        System.out.println("value : "+v);
        System.out.println();
        Gen<String> sob;
        sob = new Gen<String>("Ali Hasan");
        sob.showType();
        String str = sob.getOb();
        System.out.println("value : "+str);
    }
}
