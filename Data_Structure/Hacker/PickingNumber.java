import java.io.*;
import java.util.*;
public class PickingNumber {
    static void remove(List<Integer> a){
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(!temp.contains(a.get(i)))
                temp.add(a.get(i));
        }
        Collections.sort(temp);
        int first_count = 0,third_count=0;
        if(temp.size()==3){
            for(int i=0;i<a.size();i++){
                if(a.get(i) == temp.get(0))
                    first_count++;
                else if(a.get(i) == temp.get(2))
                    third_count++;
            }
            if(first_count<third_count){
                while(a.remove(temp.get(0))) {}
            }else{
                while(a.remove(temp.get(2))) {}
            }
        } 
    }
    static int pickingNumbers(List<Integer> a) {
        int count = 0;
        for(int i=0;i<a.size()-1;i++){
            List<Integer> temp = new ArrayList<>();
            int j=0,key = a.get(i);
            while(j<a.size()){
                int temp1 = Math.abs((key-a.get(j)));
                if(temp1 <= 1){
                    temp.add(a.get(j));
                }
                j++;
            }
            remove(temp);
            if(i==0){
                count = temp.size();
            }else if(count < temp.size()){
                count = temp.size();
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("InputPickingNumber.txt"));
        String line = "";
        while((br.readLine())!=null){
            line = br.readLine();
        }
        String[] str = line.split(" ");
        for(int i=0;i<str.length;i++){
            list.add(Integer.parseInt(str[i]));
        }
        System.out.println(pickingNumbers(list));
        br.close();
    }
}
