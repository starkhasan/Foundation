import java.io.*;
class Box{
    double width;
    double depth;
    double height;

    Box(){
        depth = height = width = 10;
    }

    double getVolume(){
        return depth*height*width;
    }
}
public class ConstructorNonparametrized {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        var obj1 = new Box();
        var obj2 = new Box();

        pw.println("Volume of the Box = "+obj1.getVolume());
        pw.println("Volume of the Box = "+obj2.getVolume());
    }
}
