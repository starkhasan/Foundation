package Hacker;
import java.io.*;
import java.util.*;
public class DesignerPDFViewer {
    
    static void setHeight(HashMap<Character,Integer> map,int[] height){
        char c = 'a';
        for(int i=0;i<height.length;i++){
            map.put(c,height[i]);
            c++;
        }
    }
    static int designerPdfViewer(int[] h, String word) {
        HashMap<Character,Integer> heightMap = new HashMap<>();
        setHeight(heightMap,h);
        int temp = 0;
        boolean isFirst = true;
        for(char c:word.toCharArray()){
            if(isFirst){
                isFirst = false;
                temp = heightMap.get(c);
            }else if(temp < heightMap.get(c)){
                temp = heightMap.get(c);
            }
        }
        return temp * word.length();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        String height = "",word = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                height = buffer.readLine();
            }else
                word = buffer.readLine();
        }
        String[] strAr = height.split(" ");
        int[] heightAr = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            heightAr[i] = Integer.parseInt(strAr[i]);
        }   
        System.out.println(designerPdfViewer(heightAr,word));
        buffer.close();
    }
}
