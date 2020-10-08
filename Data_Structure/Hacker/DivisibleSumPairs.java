import java.io.*;
public class DivisibleSumPairs {
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    int temp = ar[i] + ar[j];
                    if(temp%k == 0)
                        count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String first = "",second = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                first = buffer.readLine();
            }else{
                second = buffer.readLine();
            }
        }
        int k = Integer.parseInt(first);
        int[] ar = new int[second.split(" ").length];
        for(int i=0;i<second.split(" ").length;i++){
            ar[i] = Integer.parseInt(second.split(" ")[i]);
        }
        System.out.println(divisibleSumPairs(ar.length, k, ar));
        buffer.close();
    }
}
