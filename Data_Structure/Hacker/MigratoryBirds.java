import java.util.*;
import java.io.*;
public class MigratoryBirds {
    static int getMax(int[] ar){
        int max = 0;
        for(int i=0;i<ar.length;i++){
            if(i==0)
                max = ar[i];
            else if(max < ar[i])
                max = ar[i];
        }
        return max;
    }
    static int migratoryBirds(List<Integer> arr) {
        int result = 0;
        int[] birdId = new int[5];
        for(int i=0;i<arr.size();i++){
            switch(arr.get(i)){
                case 1:
                    birdId[0]+=1;
                    break;
                case 2:
                    birdId[1]+=1;
                    break;
                case 3:
                    birdId[2]+=1;
                    break;
                case 4:
                    birdId[3]+=1;
                    break;
                case 5:
                    birdId[4]+=1;
                    break;   
            }
        }
        int maxElement = getMax(birdId);
        for(int i=0;i<birdId.length;i++){
            if(birdId[i] == maxElement){
                result = i;
                break;
            }
        }
        return result+1;
    }
    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String first = "";
        while((buffer.readLine())!=null){
            second = buffer.readLine();
        }
        int[] ar = new int[second.split(" ").length];
        for(int i=0;i<second.split(" ").length;i++){
            list.add(Integer.parseInt(second.split(" ")[i]));
        }
        System.out.println(migratoryBirds(list));
        buffer.close();
    }
}
