import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import helper.Helper;

public class DesignerPDFViewer {
    static void assignLatter(HashMap<Character,Integer> c){
        char ch = 'a';
        for(int i=0;i<26;i++){
            c.put(ch,i);
            ch+=1;
        }   
    }

    static int designerPdfViewer(int[] h, String word) {
        int max = 0;
        HashMap<Character,Integer> mapCharacter = new HashMap<>();
        assignLatter(mapCharacter);
        for(int i=0;i<word.length();i++){
            if(i==0)
                max = h[mapCharacter.get(word.charAt(i))];
            else if(max < h[mapCharacter.get(word.charAt(i))])
                max = h[mapCharacter.get(word.charAt(i))];
        }

        return max*word.length();
    }
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedREader(new FileReader("InputHacker.txt"));
        String height = "",word = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                height = buffer.readLine();
            }else
                word = buffer.readLine();
        }
        int[] heightAr = Helper.assignArray(height.split(" "));
        System.out.println(designerPdfViewer(heightAr,word));
        buffer.close();
    }
}
