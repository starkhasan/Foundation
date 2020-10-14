package Hacker;
import java.io.*;
import java.util.*;
public class MinimumDistance {
    static void getPair(List<Integer> pairs,int[] a){
        boolean isFirst = true;
        int count = 0,temp=0;
        for(int i=0;i<a.length;i++){
            temp = a[i];
            count = 0;
            if(isFirst){
                for(int j=0;j<a.length;j++){
                    if(temp == a[j]){
                        count++;
                    }
                }
                if(count == 2){
                    pairs.add(temp);
                    isFirst = false;
                }
            }else{
                for(int j=0;j<a.length;j++){
                    if(temp == a[j]){
                        count++;
                    }
                }
                if(!pairs.contains(temp) && (count == 2)){
                    pairs.add(temp);
                }
            }
        }
    }
    static int minimumDistances(int[] a) {
        int min_dist = 0;
        boolean isFirst = true;
        List<Integer> pairs = new ArrayList<Integer>();
        getPair(pairs,a);
        if(pairs.size() > 0){
            for(int i=0;i<pairs.size();i++){
                int distance = 0;
                isFirst = true;
                for(int j=0;j<a.length;j++){
                    if(pairs.get(i) == a[j]){
                        if(isFirst){
                            distance = j;
                            isFirst = false;
                        }else{
                            distance = distance - j;
                        }
                    }
                }
                if(i==0){
                    min_dist = Math.abs(distance);
                }else if(min_dist > Math.abs(distance)){
                    min_dist = Math.abs(distance);
                }
            }
        }else{
            min_dist = -1;
        }
        return min_dist;
    }
	public static void main(String [] args)throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array : ");
		String[] strAr = buffer.readLine().split(" ");
		int[] ar = new int[strAr.length];
		for(int i=0;i<strAr.length;i++){
			ar[i] = Integer.parseInt(strAr[i]);
		}
        System.out.println("Minimum Distance = "+minimumDistances(ar));
        buffer.close();
	}
}
