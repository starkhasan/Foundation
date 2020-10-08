Patlu and Motu works in a building construction, they have to put some number of bricks N from one place to another, and started doing their work.
They decided , they end up with a fun challenge who will put the last brick.
They to follow a simple rule, In the i'th round, Patlu puts i bricks whereas Motu puts ix2 bricks.
There are only N bricks, you need to help find the challenge result to find who put the last brick.

Output "Patlu" (without the quotes) if Patlu puts the last bricks ,"Motu"(without the quotes) otherwise.


import java.util.Scanner;
 class demo
 {
 	public static void main(String [] args)
 	{
 		Scanner sc=new Scanner(System.in);
 		System.out.println("Enter Number of Bricks : ");
 		int n=sc.nextInt();
 		int m=n;
 		int motu=0,patlu=0;
 		for(int i=1;i<n;i++)
 		{
 			motu=i;
 			if(m<=i)
 			{
 				System.out.println("Patlu");
 				break;
 			}
 			m=m-motu;
 			patlu=i*2;
 			if(m<=i*2)
 			{
 				System.out.println("Motu");
 				break;
 			}
 			m=m-patlu;

 		}
 	}

 }