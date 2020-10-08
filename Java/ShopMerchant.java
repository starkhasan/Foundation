import java.util.Scanner;
public class ShopMerchant {
    public void sort(int[] ar){
        int key=0;
        for(int j=1;j<ar.length;j++){
            key=ar[j];
            int i=j-1;
            while(i>=0 && ar[i]>key){
                ar[i+1]=ar[i];
                i-=1;
            }
            ar[i+1]=key;
        }
    }
    public static void main(String[] args) {
        ShopMerchant d=new ShopMerchant();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size : ");
        int ar_size = sc.nextInt();
        int[] ar = new int[ar_size];
        System.out.println("Enter Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }
        d.sort(ar);
        int initialCount=0;
        int postion=0;
        int pairCount=0;
        for(int i=0;i<ar.length;i++){
            if(postion+1<ar.length){
                i=postion+1;
            }else{
                break;
            }
            postion=0;
            for(int j=0;j<ar.length;j++){
                if(ar[i]==ar[j]){
                    initialCount++;
                    postion=j;
                }
            }
            pairCount+=initialCount/2;
            System.out.println("Initial Count = "+initialCount);
            initialCount=0;
        }
        System.out.println("Pair Count = "+pairCount);
        sc.close();
    }
}