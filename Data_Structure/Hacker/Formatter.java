//Formatter class provides formate conversion that let you display number ,string and time and date virtually any formate you like:
import java.util.*;
class demo
{
	public static void main(String [] args)
	{
		Formatter fmt=new Formatter();
		fmt.formate("Yes i got about %n 73 %% in my six sem");
		System.out.println(fmt);
		fmt.close();
	}
}
/*
import java.util.*;
class demo
{
    public static void main(String [] args)
    {
        Formatter fmt=new Formatter();
        //fmt.format("Formatting %s is easy %d%f","with java",10,98.6);
        fmt.format("Copying file%nTrasfer is %d%% complete",88);
        System.out.println(fmt);
        fmt.close();
    }
}

*/

/*
//Specifying precision
//a precision specifier can be applied to the %f,%e and %s formate specifier
//it follows minimum field width specifier
import java.util.*;
class demo
{
    public static void main(String [] args)
    {
        Formatter fmt=new Formatter();
        fmt.format("%.4f",123.1234567);
        System.out.println(fmt);
        fmt.close();
        fmt=new Formatter();
        fmt.format("%16.2e",123.1234567);
        System.out.println(fmt);
        fmt.close();
        fmt=new Formatter();
        fmt.format("%.7s","Formatting with java is now easy");
        System.out.println(fmt);
    }
}
*/
import java.util.*;
class demo
{
    public static void main(String [] args)
    {
        Formatter fmt=new Formatter();
        fmt.format("%,.2f",4356783497.1234);
        System.out.println(fmt);
        fmt.close();
        fmt.format("%S",alihasan);
        System.out.println(fmt);
        fmt.close();
    }
}