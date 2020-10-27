import java.util.*;
import java.io.*;
public class LeftRotation {
    static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int[] ar = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ar[i] = arr.get(i);
        }
        for(int j=0;j<d;j++){
            int key = ar[0];
            for(int i=0;i<arr.size()-1;i++){
                int temp = ar[i];
                ar[i] = ar[i+1];
                ar[i+1] = temp;
            }
            ar[arr.size()-1] = key;
        }
        arr.clear();
        for(int i=0;i<ar.length;i++){
            arr.add(ar[i]);
        }
        return arr;
    }
    public static void main(String[] args) throws IOexception{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        List<Integer> listString = new ArrayList<>();
        String input = "";
        int d = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                d = Integer.parseInt(buffer.readLine());
            }else{
                input = buffer.readLine();
            }
        }
        for(int i=0;i<input.split(" ").length;i++){
            listString.add(Integer.parseInt(input.split(" ")[i]));
        }
        List<Integer> newList = rotateLeft(d,listString);
        for(int i=0;i<newList.size();i++){
            System.out.print(newList.get(i)+" ");
        }
        buffer.close(); 
    }
}
