import java.io.*;
import java.util.*;
public class BillDivision {
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int total_amount = 0;
        for(int i=0;i<bill.size();i++){
            if(i!=k){
                total_amount+=bill.get(i);
            }
        }
        int split_amount = total_amount/2;
        if(split_amount==b){
            System.out.println("Bon Appetit");
        }else{
            System.out.println((b-split_amount));
        }
    }
    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String second = "";
        boolean isFirst = true,isSecond = true;
        int k = 0,b = 0;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                k = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                second = buffer.readLine();
            }else{
                b = Integer.parseInt(buffer.readLine());
            }
        }
        for(int i=0;i<second.split(" ").length;i++){
            list.add(Integer.parseInt(second.split(" ")[i]));
        }
        bonAppetit(list,k,b);
        buffer.close();
    }
}
