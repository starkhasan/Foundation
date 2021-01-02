package Hacker;
import java.io.*;
public class ElectronicShop {
    static int getMoneySpent(int[] keyboard, int[] drives, int b) {
        int max_amount = -1;
        boolean isFirst = true;
        for(int i=0;i<keyboards.length;i++){
            for(int j=0;j<drives.length;j++){
                int amount = keyboards[i]+drives[j];
                if(amount<=b){
                    if(isFirst){
                        max_amount = amount;
                        isFirst = false;
                    }else if(max_amount < amount){
                        max_amount = amount;
                    }
                }
            }
        }
        return max_amount;
    }
    public static int[] assignArray(String[] str){
        int[] ar = new int[str.length];
        for(int i=0;i<str.length;i++)
            ar[i] = Integer.parseInt(str[i]);
        return ar;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int b = 0;
        String keyboad = "",drives = "";
        boolean isFirst = true,isSecond = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                b = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                keyboad = buffer.readLine();
            }else{
                drives = buffer.readLine();
            }
        }
        int[] keyboardAr = assignArray(keyboad.split(" "));
        int[] drivesAr = assignArray(drives.split(" "));
        System.out.println(getMoneySpent(keyboardAr,drivesAr,b));
        buffer.close();
    }
}
