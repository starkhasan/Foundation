import java.io.*;
import java.util.Scanner;
class demo{
    public static void main(String[] args)throws FileNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Author : Ali Hasan");
        System.out.print("Enter Singer Name : ");
        String singer_name=sc.nextLine();
        File file=new File("F:/sid_new/Music");
        String filename[]=file.list();
        int singer_song_count=0;
        for(String new_file:filename){
            String matcher="";
            for(int i=0;i<new_file.length();i++){
                int count=0;
                for(int j=i;j<new_file.length();j++){
                    matcher=matcher+String.valueOf(new_file.charAt(j));
                    count++;
                    if(count==singer_name.length()){
                        if(matcher.equalsIgnoreCase(singer_name)){
                            System.out.println(new_file);
                            singer_song_count++;
                            break;
                        }
                        count=0;
                        matcher="";
                    }
                }
                if(matcher.equalsIgnoreCase(singer_name)){
                    break;
                }
            }
        }
        if(singer_song_count==0){
            System.out.println("Sorry! No Song of "+singer_name);
        }else{
            System.out.println("\n\nTotal Number of Song of "+singer_name+" "+singer_song_count);
        }
        sc.close();
    }
}
