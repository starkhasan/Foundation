Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
Function Description
Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
timeConversion has the following parameter(s):
s: a string representing time in  12hour format
Input Format
A single string s containing a time in 12-hour clock format (i.e.:  hh:mm:ssAM or  hh:mm:ssPM ), where  01<=hh<=12 and 00<=mm,ss<=59
Constraints:-
All input times are valid
Output Format
Convert and print the given time in 24-hour format, where 00<=hh<=23.
Sample Input 0

07:05:45PM
Sample Output 0

19:05:45


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s)
    {
        String s1=s.substring(8);
        //System.out.println(s1);
        String s2=s.substring(0,2);
        //System.out.println(s2);
        int new_time=Integer.parseInt(s2);
        if(s1.equals("AM"))
        {
            if(new_time==12)
            {
                String new_str="00";
                String new_str2=s.substring(2,8);
                s1=new_str+new_str2;
                //System.out.println(new_str);
            }
            else
            {
                s1=s.substring(0,8);
            }
            //System.out.println(s1);
        }
        else
        {
           if(new_time==12)
            {
                String new_str=Integer.toString(new_time);
                String new_str2=s.substring(2,8);
                s1=new_str+new_str2;
                //System.out.println(new_str);
            }
            else
            {
                new_time=new_time+12;
                String new_str=Integer.toString(new_time);
                String new_str2=s.substring(2,8);
                s1=new_str+new_str2;
                //System.out.println(new_str);
            }
            //System.out.println(new_str);
        
        }

        return s1;
        /*
         * Write your code here.
         */

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
