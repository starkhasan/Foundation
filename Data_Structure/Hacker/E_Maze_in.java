Ankit is in maze. The command center sent him a string which decodes to come out from the maze. He is initially at (0, 0).
String contains L, R, U, D denoting left, right, up and down. In each command he will traverse 1 unit distance in the respective direction.

For example if he is at (2, 0) and the command is L he will go to (1, 0).

Input=> LLRDDR                                                          output=> 0 -2

 
 
import java.util.Scanner;
class demo
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String : ");
		String str=sc.nextLine();
		int lr=0,ud=0;
		int str_len=str.length();		
		
		for(int i=0;i<str_len;i++)
		{
			if(str.charAt(i)=='L')
			{
				lr=lr-1;
			}
			else if(str.charAt(i)=='R')
			{
				lr=lr+1;
			}
			else if(str.charAt(i)=='U')
			{
				ud=ud+1;
			}
			else if(str.charAt(i)=='D')
			{
				ud=ud-1;
			}
		}

		System.out.println(lr+" "+ud);
	}
}
