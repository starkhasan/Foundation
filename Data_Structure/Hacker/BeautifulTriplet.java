package Hacker;
import java.io.*;
public class BeautifulTriplet {
    static int beautifulTriplets(int d, int[] arr) {
        int count = 0,result=0,temp=0;
        for(int i=0;i<arr.length;i++){
            temp = arr[i];
            count=0;
            for(int j=i;j<arr.length;j++){
                if(arr[j]-temp == d){
                    temp = arr[j];
                    count++;
                    if(count==2)
                        break;
                }
            }
            if(count==2){
                result++;
            }
        }
        return result;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array : ");
		String[] strAr = buffer.readLine().split(" ");
		System.out.println("Enter Beautiful difference : ");
		int d = Integer.parseInt(buffer.readLine());
		int[] arr = new int[strAr.length];
		for(int i=0;i<strAr.length;i++)
			arr[i] = Integer.parseInt(strAr[i]);
        System.out.println(beautifulTriplets(d,arr));
        buffer.close();
	}
}
