package Hacker;
import java.io.*;
public class HundleRace {
    static int hurdleRace(int k, int[] height) {
        int potion = 0,max = 0;
        for(int i=0;i<height.length;i++){
            if(i==0)
                max = height[i];
            else if(max < height[i])
                max = height[i];
        }
        if(k < max)
            potion = max - k;
        return potion;
    }
    public static int[] assignArray(String[] strArray){
        int[] ar = new int[strArray.length];
        for(int i=0;i<strArray.length;i++)
            ar[i] = Integer.parseInt(strArray[i]);
        return ar;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int k = 0;
        String height_input = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                k = Integer.parseInt(buffer.readLine());
            }else{
                height_input = buffer.readLine();
            }
        }
        int[] height = assignArray(height_input.split(" "));
        System.out.println(hurdleRace(k,height));
        buffer.close();
    }
}
