import java.io.PrintWriter;
import java.util.Random;
interface SharedConstants{
    int NO = 0;
    int YES = 1;
    int MAYBE = 2;
    int LATER = 3;
    int SOON = 4;
    int NEVER = 5;
}
class Questions implements SharedConstants{
    Random rand = new Random();
    int ask(){
        int prob = (int)(100 * rand.nextDouble());
        if(prob < 30)
            return NO;
        else if(prob < 60)
            return YES;
        else if(prob < 75)
            return LATER;
        else if(prob < 98)
            return SOON;
        else
            return NEVER;
    }
}
public class InterfaceVariable implements SharedConstants{
    private static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void answer(int result){
        switch (result) {
            case NO -> pw.println("No");
            case YES -> pw.println("Yes");
            case MAYBE -> pw.println("Maybe");
            case LATER -> pw.println("Later");
            case SOON -> pw.println("Soon");
            case NEVER-> pw.println("Never");
        }
    }

    public static void main(String[] args) {
        Questions obj = new Questions();
        answer(obj.ask());
        answer(obj.ask());
        answer(obj.ask());
        answer(obj.ask());
        answer(obj.ask());
    }
}
