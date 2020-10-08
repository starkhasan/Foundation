import java.util.*;
public class MergeSort {
    public void merge(int a[],int p,int q,int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i] = a[p+i];
        }
        for(int i=0;i<n2;i++){
            rightArray[i] = a[q+1+i];
        }
        
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
        a[k] = leftArray[i];
        i++;
        k++;
        }

        while (j < n2) {
        a[k] = rightArray[j];
        j++;
        k++;
        }
    }

    public void mergeSort(int a[],int p,int r){
        int q;
        if(p<r){
            q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a,p,q,r);
        }
    }
    public static void main(String[] args) {
        MergeSort d = new MergeSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int ar_size = sc.nextInt();
        int[] ar=new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }
        d.mergeSort(ar, 0, ar.length-1);
        System.out.println();
        System.out.println("Sorted Array : ");
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
        sc.close();
    }
}
