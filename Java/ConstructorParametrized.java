import java.io.*;
class Box{
    double width;
    double depth;
    double height;

    Box(double size){
        depth = height = width = size;
    }

    double getVolume(){
        return depth*height*width;
    }
}
public class ConstructorParametrized {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        var obj1 = new Box(10);
        var obj2 = new Box(20);
        pw.println("Volume of Box using Object1  = "+obj1.getVolume());
        pw.println("Volume of Box using Object2 = "+obj2.getVolume());
    }
}
