import java.io.*;
class Demo{
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String str = "Hello!how,are you!my,name is ali hasan";
        String[] strAr = str.split("[!,\\s]+");
        System.out.println(strAr.length);
        for(String s:strAr){
            System.out.println(s);
        }
        buffer.close();
    }
}