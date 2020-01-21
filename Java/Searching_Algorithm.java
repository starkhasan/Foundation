import java.io.*;
import java.util.Scanner;
class demo{
    public static void main(String[] args){

        try {
            File file=new File("D:/Repo/Data_Structure/alitxt.txt");
            Scanner sc=new Scanner(file);
            int count=0;
            while(sc.hasNext()){
                String str="string";
                if(str.equalsIgnoreCase(sc.next())){
                    count++;
                } 
            }
            System.out.println("\nTotal Number of Count java = "+count);
            sc.close();
        } catch (Exception e) {
            System.out.println("not found");
        }
        
    }
}