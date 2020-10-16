package Hacker;
import java.io.*;
public class IceCreamParlor {
    static int[] icecreamParlor(int m, int[] arr) {
        int[] price = new int[2];
        int temp = 0;
        boolean isFound = false;
        for(int i=0;i<arr.length;i++){
            isFound = false;
            for(int j=i;j<arr.length;j++){
                temp = arr[i] + arr[j];
                if(i!=j && temp==m){
                    isFound = true;
                    price[0] = i+1;
                    price[1] = j+1;
                    break;
                }
            }
            if(isFound)
                break;
        }
        return price;
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String input = "";
        int price = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                price = Integer.parseInt(buffer.readLine());
            }else{
                input = buffer.readLine();
            }
        }
        int[] arr = new int[input.split(" ").length];
        for(int i=0;i<input.split(" ").length;i++)
            arr[i] = Integer.parseInt(input.split(" ")[i]);
        int[] result = icecreamParlor(price,arr);
        printArray(result);
        buffer.close();
    }
}
