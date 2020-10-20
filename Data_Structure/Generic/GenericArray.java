package Generic;
class Printer{
    public <T> void printArray(T[] num){
        for(int i=0;i<num.length;i++)
             System.out.println(num[i]);
    }
 }
public class GenericArray {
    public static <T> void printInput(T x){
        System.out.println(x);
    }
    public static void main(String[] args){
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}
