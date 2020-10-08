import java.io.*;
public class BinarySearch{
    public void display(int[] ar){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(ar[j] < key){
                i+=1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = temp;
        return i+1;
    }
    public void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1, r);
        }
    }
    public void removeDuplicateNumber(int[] ar){
        int maxElement = ar[ar.length-1];
        int[] countAr = new int[maxElement+1];
        for(int i=0;i<=maxElement;i++){
            countAr[i]=0;
        }
        for(int i=0;i<ar.length;i++){
            countAr[ar[i]] = countAr[ar[i]] + 1; 
        }
        for(int i=0;i<countAr.length;i++){
            System.out.println(i+" Repeat "+countAr[i]+" times");
        }
    }
    public int binarySearch(int[] ar,int p,int r,int key){
        if(p<=r){
            int mid = (p+r)/2;
            if(ar[mid] == key)
                return mid;
            if(ar[mid] > key)
                return binarySearch(ar, p, mid-1, key);
            return binarySearch(ar, mid+1, r, key);
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BinarySearch demo = new BinarySearch();
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String line = "";
        int element = 0;
        boolean isFirst = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                line = buffer.readLine();
            }else{
                element = Integer.parseInt(buffer.readLine());
            }
        }
        String[] strAr = line.split(" ");
        int[] ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            ar[i] = Integer.parseInt(strAr[i]);
        }
        System.out.println("UnSorted Array");
        demo.display(ar);
        System.out.println("\nSorted Array OutPut");
        demo.quickSort(ar,0,ar.length-1);
        demo.display(ar);
        System.out.println("\nAfter Removing Duplicate Number : ");
        demo.removeDuplicateNumber(ar);
        int result = demo.binarySearch(ar,0,ar.length-1,element);
        if(result<0)
            System.out.println("Result not found");
        else
            System.out.println("Result found at position "+result);
        buffer.close();
    }
}
