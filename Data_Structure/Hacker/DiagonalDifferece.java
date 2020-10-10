import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import helper.Helper;
public class DiagonalDifferece {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1 = 0,diag2 = 0;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                if(i==j){
                    diag1+=arr.get(i).get(j);
                    if(i+j == arr.size()-1)
                        diag2+=arr.get(i).get(j);
                }else if(i+j == arr.size()-1){
                    diag2+=arr.get(i).get(j);
                }
            }
        }
        return Math.abs((diag1-diag2));
    }
    public static void main(String[] args) {
        
    }
}
