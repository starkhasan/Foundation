wTask 
Given a string, S, of length  N that is indexed from  0 to N-1, print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line 
(see the Sample below for more detail).

Note:  0 is considered to be an even index.


Sample Input
2
Hacker
Rank

Sample Output
Hce akr
Rn ak

Explanation

Test Case 0:  S="Hacker"
 S[0]="H";
 S[1]="a";
 S[2]="c";
 S[3]="k";
 S[4]="e";
 S[5]="r";
 
The even indices are 0,2 , and 4, and the odd indices are 1, 3, and 5. We then print a single line of  2 space-separated strings; the first string contains the ordered characters
from S"s even indices (Hce), and the second string contains the ordered characters from S's odd indices (akr).

Test Case 1:  S="Rank"
 S[0]="R";
 S[1]="a";
 S[2]="n";
 S[3]="k";
 
The even indices are  0 and 2, and the odd indices are 1 and 3. We then print a single line of  2 space-separated strings; the first  string contains the ordered characters
from S"s even indices (Rn), and the second string contains the ordered characters from S's odd indices (ak).



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution
{
    public void partition(String str)
    {
        char c[]=str.toCharArray();
        int str_length=c.length;
        String even="";
        String odd="";
        for(int i=0;i<str_length;i++)
        {
            if(i%2==0)
            {
                even=even+c[i];
            }
            else
            {
                odd=odd+c[i];
            }
        }

        System.out.println(even+" "+odd);

    }

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int str_size=sc.nextInt();
        sc.nextLine();
        String str[]=new String[str_size];
        Solution d=new Solution();
        for(int i=0;i<str_size;i++)
        {
            str[i]=sc.nextLine();
            d.partition(str[i]);
        }
    }
}

