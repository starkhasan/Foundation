import java.io.*;
public class BreakingTheRecords {
    static int[] breakingRecords(int[] scores) {
        int[] result = new int[2];
        int min = 0,max = 0,minCount = 0,maxCount = 0;
        for(int i=0;i<scores.length;i++){
            if(i==0){
                max = min = scores[i];
            }else{
                if(min > scores[i]){
                    min = scores[i];
                    minCount+=1;
                }
                if(max < scores[i]){
                    max = scores[i];
                    maxCount+=1;
                }
            }
        }
        result[0] = maxCount;
        result[1] = minCount;
        return result;
    }
    static void printArray(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        int[] scores = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            scores[i] = Integer.parseInt(strAr[i]);
        }
        int[] result = breakingRecords(scores);
        printArray(result);
        buffer.close();
    }
}
