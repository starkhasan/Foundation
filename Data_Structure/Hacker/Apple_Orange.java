package Hacker;
import java.io.*;
public class Apple_Orange {
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int numberApple = 0,numberOrange=0;
        for(int i=0;i<apples.length;i++){
            apples[i]+=a;
        }
        for(int i=0;i<oranges.length;i++){
            oranges[i]+=b;
        }
        for(int i=0;i<apples.length;i++){
            if(apples[i]>= s && apples[i]<=t){
                numberApple++;
            }
        }
        for(int i=0;i<oranges.length;i++){
            if(oranges[i]>= s && oranges[i]<=t){
                numberOrange++;
            }
        }
        System.out.print(numberApple+"\n"+numberOrange);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String first = "",second = "",third = "",forth = "";
        int s = 0,t = 0,a = 0,b = 0;
        boolean isFirst = true,isSecond = true,isThird = true,isForth=true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                first = buffer.readLine();
            }else if(isSecond){
                isSecond = false;
                second = buffer.readLine();
            }else if(isThird){
                isThird = false;
                third = buffer.readLine();
            }else if(isForth){
                isForth = false;
                forth = buffer.readLine();
            }
        }
        String[] strFirst = first.split(" ");
        s = Integer.parseInt(strFirst[0]);
        t = Integer.parseInt(strFirst[1]);
        String[] strSecond = second.split(" ");
        a = Integer.parseInt(strSecond[0]);
        b = Integer.parseInt(strSecond[1]);
        String[] strThird = third.split(" ");
        int[] apples = new int[strThird.length];
        for(int i=0;i<strThird.length;i++){
            apples[i] = Integer.parseInt(strThird[i]);
        }
        String[] strForth = forth.split(" ");
        int[] oranges = new int[strForth.length];
        for(int i=0;i<strForth.length;i++){
            oranges[i] = Integer.parseInt(strForth[i]);
        }
        countApplesAndOranges(s,t,a,b,apples,oranges);
        buffer.close();
    }
}
