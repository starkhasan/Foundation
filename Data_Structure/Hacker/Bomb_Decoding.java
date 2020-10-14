//Bomb Decoding
package Hacker;
import java.util.*;
class BombDecoding{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size");
        int n = sc.nextInt();
        System.out.println("Enter the Key : ");
        int key = sc.nextInt();

        int a[] = new int[n];
        System.out.println("Enter Element in Array : ");
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        int k=1,count=0,j=0,sum=0;
        int b[]=new int[n];

        for(int i=0;i<n;i++){
        	j=i;
        	while(j<n && count<key){
        		if(j+k<n){
        			sum+=a[j+k];
        			b[i]=sum;
        			j++;
        			count++;
        		}
        		else{
        			j=0;
        			sum+=a[j];
        			b[i]=sum;
        			count++;
        		}
        	}
            count=0;
            sum=0;
        }
        System.out.println("Resultant = ");
        for(int i=0;i<n;i++)
            System.out.print(b[i]+" ");
        sc.close();
    }
}