package Hacker;
import java.io.*;

public class Drawing_Book {
    static int pageCount(int total_pages, int pageNumber) {
        int mid = total_pages/2;
        int pageTurn = 0;
        if(pageNumber>mid){
            int temp = total_pages - pageNumber;
            if(temp==1){
                if(total_pages%2==0){
                    pageTurn = 1;
                }else{
                    pageTurn = 0;
                }
            }else{
                pageTurn = temp/2;
            }
        }else{
            pageTurn = pageNumber/2;
        }
        return pageTurn;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int n = 0,p = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                n = Integer.parseInt(buffer.readLine());
            }else{
                p = Integer.parseInt(buffer.readLine());
            }
        }
        System.out.println(pageCount(n,p));
        buffer.close();
    }
}
