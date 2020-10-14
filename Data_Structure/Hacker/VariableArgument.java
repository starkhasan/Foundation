package Hacker;
import java.util.*;
class Add{
	public void add(int ... args){
		System.out.println("Length of the Argument = "+args.length);
		for(int i=0;i<args.length;i++){
			System.out.print(args[i]+" ");
		}
	}
}
public class VariableArgument{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		Add obj = new Add();
        obj.add(1,2,3,4,5);
        sc.close();
	}
}
