import java.util.*;
import java.io.*;
public class TimeInWords{
    public static void init(HashMap<Integer,String> numbers){
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteeen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
    }
    public static void main(String[] args) throws IOException{
        HashMap<Integer,String> number = new HashMap<>();
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        init(number);
        String input = "";
        String result = "";
        int hour = 0,minutes = 0;
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        hour = Integer.parseInt(strAr[0]);
        minutes = Integer.parseInt(strAr[1]);
        
        if(minutes==0){
            result = number.get(hour)+" o' clock";
        }else{
            if(minutes>30){
                if(minutes==45){
                    if(hour==12)
                        result = "quarter to "+number.get(1);
                    else
                        result = "quarter to "+number.get(hour+1);
                }else{
                    String strMinutes = String.valueOf(60-minutes);
                    if((60-minutes) <= 20){
                        if(hour==12)
                            result = number.get((60-minutes))+" minutes to "+number.get(1);
                        else
                            result = number.get((60-minutes))+" minutes to "+number.get(hour+1);
                    }else{
                        int firstMinutes = Integer.parseInt(strMinutes.substring(0,1))*10;
                        int lastMinute = Integer.parseInt(strMinutes.substring(1));
                        String tempTime = number.get(firstMinutes)+" "+number.get(lastMinute);
                        if(hour==12)
                            result = tempTime+" minutes to "+number.get(1);
                        else
                            result = tempTime+" minutes to "+number.get(hour+1);
                    }
                }
            }else {
                if(minutes==30){
                    result = "half past "+number.get(hour);
                }else if(minutes==15){
                    result =  "quarter past "+number.get(hour);
                }else{
                    String strMinutes = String.valueOf(minutes);
                    if(minutes <= 20){
                        if(minutes==1)
                            result = number.get(minutes)+" minute past "+number.get(hour);
                        else
                            result = number.get(minutes)+" minutes past "+number.get(hour);
                    }else{
                        int firstMinutes = Integer.parseInt(strMinutes.substring(0,1))*10;
                        int lastMinute = Integer.parseInt(strMinutes.substring(1));
                        String tempTime = number.get(firstMinutes)+" "+number.get(lastMinute);
                        result = tempTime+" minutes past "+number.get(hour);
                    }
                }
            }
        }
        System.out.println(result);
        buffer.close();
    }
}
