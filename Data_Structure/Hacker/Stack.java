package Hacker;
import java.util.*;
class StackX{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	public void push(char j){
		stackArray[++top] = j;
	}
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
}
class BracketChecker{
	private String input;
	public BracketChecker(String in){
		input = in;
	}
	public void check(){
		int stackSize = input.length();
		StackX stack = new StackX(stackSize);
		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);
			switch(ch){
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
				case ']':
				case ')':
					if(!stack.isEmpty()){
						char chx = stack.pop();
						if( (ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(') )
							System.out.println("Error: "+ch+" at "+i);
					}else
						System.out.println("Error : "+ch+" at "+i);
					break;
				default:
					break;
			}
		}
		if(!stack.isEmpty())
			System.out.println("Error: missing right delimiter");
	}
}
public class Stack {
    public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String input;
		while(true){
			System.out.println("Enter String containing delimiters : ");
			input = sc.nextLine();
			if(input.equals(""))
				break;
			BracketChecker demo = new BracketChecker(input);
			demo.check();
        }
        sc.close();
	}
}
