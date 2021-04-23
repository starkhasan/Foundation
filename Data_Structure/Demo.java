import java.io.*;
class Demo{
    static int[] rotate(int[] a,int d){
        while(d > 0){
            int key = a[0];
            for(int i=0;i<a.length-1;i++){
                a[i] = a[i+1];
            }
            a[a.length-1] = key;
            d-=1;
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String[] array = new String[0];
        int d = 0;
        boolean isFirst = true;
        while((buffer.readLine())!= null){
            if(isFirst){
                array = buffer.readLine().split(" ");
                isFirst = false;
            }else{
                d = Integer.parseInt(buffer.readLine());
            }
        }
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++){
            arr[i] = Integer.parseInt(array[i]);
        }

        int[] newArr = rotate(arr,d);
        for(int items:newArr){
            System.out.print(items+" ");
        }
        buffer.close();
    }
}