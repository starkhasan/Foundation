interface Callback{
    void callback(int param);
}
//partial implementation
abstract class InComplete implements Callback{
    abstract void abstractMethod();
    void show(){
        System.out.println("This is concrete method");
    }
}
class Client extends InComplete{
    @Override
    public void callback(int param){
        System.out.println("callback called with "+param);
    }

    @Override
    public void abstractMethod(){
        System.out.println("This is abstract method");
    }
}
public class InterfacePartialImplement {
    public static void main(String[] args) {
        var obj = new Client();
        obj.callback(42);
        obj.abstractMethod();
        obj.show();
    }   
}
