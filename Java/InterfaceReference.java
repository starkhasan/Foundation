interface Callback{
    void callback(int param);
}
class Client implements Callback{
    @Override
    public void callback(int param){
        System.out.println("callback called with "+param);
    }

    void nonInterfaceMeth(){
        System.out.println("Classes that implement inerface");
    }
}
class AnotherClient implements Callback{
    @Override
    public void callback(int param){
        System.out.println("Another version of callback");
        System.out.println("p square is "+Math.pow(param,2));
    }

    void nonIfaceMethAnother(){
        System.out.println("This is Another class that implement interface");
    }
}
public class InterfaceReference {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();
        c.callback(42);
        c = ob;
        c.callback(42);
        //c.nonIfaceMethAnother();
    }
}
