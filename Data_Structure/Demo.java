import java.io.*;
class Demo{
    public static <T> void printInput(T x){
        System.out.println(x);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        while((buffer.readLine())!=null){
            printInput(buffer.readLine());
        }
        buffer.close();
    }
}