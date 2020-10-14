package Hacker;
import java.io.*;
public class ElectronicShop {
    static int getMoneySpent(int[] keyboard, int[] drives, int b) {
        int maxPrice = 0;
        for(int i=0;i<keyboard.length;i++){
            int key = keyboard[i];
            for(int j=0;j<drives.length;j++){
                if((key+drives[j]) <= b){
                    if(i==0 && j==0){
                        maxPrice = (key+drives[j]);
                    }else if(maxPrice < (key+drives[j])){
                        maxPrice = (key+drives[j]);
                    }
                }
            }
        }
        if(maxPrice>0)
            return maxPrice;
        else
            return -1;
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
