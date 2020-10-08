class demo
{
	public int setdata(int num1,int num2)
		{
			if(num1<num2)
				throw new ArithmeticException("sorry");
			else
			{
				int temp=num1-num2;
				return temp;
			}
		}
	public static void main(String [] args)
	{
		demo d=new demo();
		int a=10,b=20;
		int c=d.setdata(a,b);
		System.out.println(c);
	}
}
		