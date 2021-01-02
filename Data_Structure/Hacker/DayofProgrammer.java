import java.util.*;
import java.io.*;
public class DayofProgrammer {
    static boolean isLeap(int year){
        if(year%400==0){
            return true;
        }else if((year%4==0) && (year%100!=0)){
            return true;
        }else{
            return false;
        }
    }
    static String dayOfProgrammer(int year) {
        String result = "";
        if(year == 1918){
            int temp = 256 - (244 - 14);
            result = String.valueOf(temp)+".09."+String.valueOf(year);
        }else if(year > 1918){
            if(isLeap(year)){
                result = "12.09."+String.valueOf(year);
            }else{
                result = "13.09."+String.valueOf(year);
            }
        }else{
            if(year%4 == 0){
                result = "12.09."+String.valueOf(year);
            }else{
                result = "13.09."+String.valueOf(year);
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        System.out.println(dayOfProgrammer(Integer.parseInt(input)));
        buffer.close();
    }
}
