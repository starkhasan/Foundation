import java.io.*;
public class DigitNumber {
    public static int totalOccurance(int left,int right,int X){
        int count = 0;
        left+=1;
        for(int i=left;i<right;i++){
            int temp = i;
            while(temp>0){
                int rem = temp%10;
                if(rem == X)
                    count++;
                temp = temp/10;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        boolean isFirst = true;
        boolean isSecond = true;
        int L = 0;
        int R = 0;
        int X = 0;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                L = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                R = Integer.parseInt(buffer.readLine());
            }else{
                X = Integer.parseInt(buffer.readLine());
            }
        }
        int result = totalOccurance(L,R,X);
        System.out.println(result);
        buffer.close();
    }
}
