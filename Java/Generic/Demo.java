import java.io.*;
class Demo{
    static <T> void sort(T[] X){
        for(int i=0;i<X.length;i++)
            System.out.print(X[i]+" ");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = buffer.readLine();
        String[] strAr = str.split(" ");
        sort(strAr);
    }
}