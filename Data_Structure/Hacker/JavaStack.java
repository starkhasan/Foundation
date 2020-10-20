package Hacker;
import java.io.*;
import java.util.*;
public class JavaStack {
    static boolean isStack(String str){
        List<Character> listChar = new ArrayList<>();
        char recentChar = Character.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                recentChar = str.charAt(i);
                listChar.add(str.charAt(i));
            }else{
                if(listChar.size() == 0 && (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']')){
                    listChar.add(str.charAt(i));
                    break;
                }else if(str.charAt(i) == '}' && recentChar == '{'){
                    listChar.remove(listChar.size()-1);
                    if(listChar.size()!=0)
                        recentChar = listChar.get(listChar.size()-1);
                }else if(str.charAt(i) == ')' && recentChar == '('){
                    listChar.remove(listChar.size()-1);
                    if(listChar.size()!=0)
                        recentChar = listChar.get(listChar.size()-1);
                }else if(str.charAt(i) == ']' && recentChar == '['){
                    listChar.remove(listChar.size()-1);
                    if(listChar.size()!=0)
                        recentChar = listChar.get(listChar.size()-1);
                }else{
                    break;
                }
            }
        }
        if(listChar.size() == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
            if(isStack(input)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
        buffer.close();
    }
}
