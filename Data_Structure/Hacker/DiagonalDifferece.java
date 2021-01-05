import java.io.*;
import java.util.*;
public class DiagonalDifferece {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1 = 0,diag2 = 0;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                if(i==j){
                    diag1+=arr.get(i).get(j);
                }
                if(i+j == arr.size()-1){
                    diag2+=arr.get(i).get(j);
                }
            }
        }
        return Math.abs((diag1-diag2));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
            String[] strAr = input.split(" ");
            List<Integer> tempList = new ArrayList<>();
            for(String s:strAr){
                tempList.add(Integer.parseInt(s));
            }
            list.add(tempList);
        }
        int result = diagonalDifference(list);
        System.out.println("Result = "+result);
    }
}
