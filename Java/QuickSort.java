import java.util.Scanner;
public class QuickSort {

    public void quickSort(int ar[],int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1,r);
        }
    }

    public int partition(int ar[],int p,int r){
        int x = ar[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(ar[j]<=x){
                i = i+1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        QuickSort demo = new QuickSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int ar_size = sc.nextInt();
        int ar[] = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i] = sc.nextInt();
        }
        demo.quickSort(ar,0,ar_size-1);
        for(int i=0;i<ar_size;i++){
            System.out.print(ar[i]+" ");
        }
        sc.close();
    }

}