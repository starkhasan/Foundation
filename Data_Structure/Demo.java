import java.io.*;
import java.util.*;
public class Demo{
    static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int k = 0;
        while(k<d){
            int key = arr.get(0);
            for(int i=0;i<arr.size()-1;i++){
                arr.set(i,arr.get(i+1));
            }
            arr.set(arr.size()-1,key);
            k++;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException{
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
