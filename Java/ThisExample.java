import java.io.*;
class Box{
    /**
     * thse are instance variable of class
     */
    double height;
    double width;
    double depth;

    /**
     * when the local variable has the same as of the insatance variable than local variable hide the instance varible (Instance variable Hiding)
     * to resolve this issue we use this keyword
     * this keyword is used to refer current class instance / object
     */
    Box(double width,double height,double depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    double getVolume(){
        return width*height*depth;
    }
}
public class ThisExample {
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        var boxObject = new Box(10,20,40);//creaitng object of class 
        pw.println("Volume of Box = "+boxObject.getVolume());
    }
}
