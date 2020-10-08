import java.io.*;
public class IndexMapping {
    final static int MAX = 1000;
    static boolean[][] has = new boolean[MAX][2];
    static boolean search(int X){ 
        if(X>=0){ 
            if (has[X][0] == true)   
                return true; 
            else 
                return false; 
        }   
        X = Math.abs(X); 
        if (has[X][1] == true)  
            return true; 
        return false; 
    } 
  
    static void insert(int a[], int n){ 
        for (int i = 0; i < n; i++){
            if (a[i] >= 0)
                has[a[i]][0] = true;
            else
                has[Math.abs(a[i])][1] = true;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHashing.txt"));
        System.out.println("Enter Element ot Search : ");
        int X = 0;
        String input = "";
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                input = buffer.readLine();
            }else{
                X = Integer.parseInt(buffer.readLine());
            }
        }
        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }
        int n = ar.length;
        insert(ar,n);
        if(search(X) == true)
            System.out.println("Present");     
        else
            System.out.println("Not Present");
        buffer.close();
    }
}
