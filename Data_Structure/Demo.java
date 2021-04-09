import java.io.*;
import java.util.*;
class Demo{
    public static String PartyType( long a[]){
        String party =  "GIRLS";
        List<Long> list = new ArrayList<Long>();
        for(long element:a){
            if(list.contains(element)){
                party = "BOYS";
                break;
            }else{
                list.add(element);
            }
        }
        return party;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] str = input.split(" ");
        long[] lng = new long[str.length];
        int i=0;
        for(String s:str){
            lng[i] = Long.parseLong(s);
            i+=1;
        }
        System.out.println(PartyType(lng));
        buffer.close();
    }
}