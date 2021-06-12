import java.io.*;
public class BinarySearch {

    public static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i = p-1;
        int temp = 0;
        for(int j=p;j<r;j++){
            if(ar[j] < key){
                i = i+1;
                temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }

    public static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1,r);
        }
    }

    public static int binarySearch(int[] ar,int left,int right,int searchElement){
        if(left<=right){
            int mid = (left+right)/2;
            if(ar[mid] == searchElement)
                return mid;
            
            if(searchElement < ar[mid])
                return binarySearch(ar, left, mid-1, searchElement);

            return binarySearch(ar, mid+1, right, searchElement);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputArray.txt"));
        String input = "";
        boolean isFirst = true;
        int searchElement = 0;


        while(buffer.readLine()!=null){
            if(isFirst){
                isFirst = false;
                input = buffer.readLine();
            }else{
                searchElement = Integer.parseInt(buffer.readLine());
            }
            
        }




        String[] strAr = input.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }
        quickSort(ar,0,ar.length-1);
        int item = binarySearch(ar,0,ar.length-1,searchElement);
        if(item != -1){
            System.out.println(searchElement+" present at "+item+" position");
        } else{
            System.out.println("Search Item Not Found");
        }
        buffer.close();
    }

}
