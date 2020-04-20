import java.util.Scanner;
public class BinarySearch {

    public int partition(int ar[],int p,int r){
        int x = ar[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(ar[j]<=x){
                i=i+1;
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
    public void quickSort(int ar[],int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    public int binarySearch(int ar[],int p,int r,int search_element){
        if(p<=r){
            int mid = (p+r)/2;
            if(ar[mid] == search_element){
                return mid;
            }
            if(ar[mid] > search_element){
                return binarySearch(ar, p, mid-1, search_element);
            }
            if(ar[mid] < search_element){
                return binarySearch(ar, mid+1, r, search_element);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch d=new BinarySearch();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the Array : ");
        int ar_size = sc.nextInt();
        int ar[] = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }
        d.quickSort(ar,0,ar_size-1);
        System.out.println("Enter the Element Do you want to Search : ");
        int search_element = sc.nextInt();
        int result = d.binarySearch(ar,0,ar_size-1,search_element);
        if(result==-1){
            System.out.println(search_element+" Not Found in the List");
        }else{
            System.out.println(search_element+" Found at Position "+(result+1));
        }
        sc.close();
    }

}