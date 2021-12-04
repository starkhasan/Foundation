abstract class Product{
    int multiplyBy;
    public Product(int multiplyBy){
        this.multiplyBy = multiplyBy;
    }

    public int multiply(int val){
        return this.multiplyBy *val;
    }
}
public class AbstractClassConstructor extends Product{

    public AbstractClassConstructor(int multiplyBy) {
        super(multiplyBy);
    }

    public static void main(String[] args) {
        new AbstractClassConstructor(2);
    }

}
