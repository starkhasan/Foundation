interface One{
    void print_geek();
}
interface Two{
    void print_for();
}
interface Three extends One,Two{
}
class Child implements Three{
    @Override
    public void print_geek(){
        System.out.print("Geeks");
    }

    @Override
    public void print_for(){
        System.out.print(" For ");
    }
}
public class MultipleInheritance {
    /**
     * Since multiple inheritance is not possible at class level
     * It can be implemented by using interface 
     * */
    public static void main(String[] args) {
        Child obj = new Child();
        obj.print_geek();
        obj.print_for();
        obj.print_geek();
    }
}


