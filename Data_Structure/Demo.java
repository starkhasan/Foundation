import java.io.*;
import java.util.*;
class Demo{
    static int calculation(int[][] ar){
        int ar_size = ar.length;
        int count = 0;
        for(int i=0;i<ar_size;i++){
            for(int j=0;j<ar_size;j++){
                if((i==1 && j==0) || (i==1 &&j==2)){
                    continue;
                }else{
                    count+=ar[i][j];
                }
            }
        }
        return count;
    }
    static int hourglassSum(int[][] arr) {
        List<Integer> maxSum = new ArrayList<Integer>();
        int outer_count = 0;
        int inner_count = 0;
        for(int i=0;i<=arr.length-3;i++){
            for(int j=0;j<=arr.length-3;j++){
                int k=i;
                int l=j;
                int temp[][] = new int[3][3];
                outer_count = 0;
                while(outer_count<3){
                	l=j;
                	inner_count = 0;
                    while(inner_count<3){
                        temp[outer_count][inner_count] = arr[k][l];
                        inner_count++;
                        l++;
                    }
                    k++;
                    outer_count++;
                }
                maxSum.add(calculation(temp));
            }
        }

        int max = 0;
        for(int i=0;i<maxSum.size();i++){
        	if(i==0){
        		max = maxSum.get(i);
        	}else if(max < maxSum.get(i)){
            	max = maxSum.get(i);
        	}
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Size of Array : ");
		int ar_size = Integer.parseInt(buffer.readLine());
		int[][] ar = new int[ar_size][ar_size];
		System.out.println("Enter Element in Array : ");
		for(int i=0;i<ar_size;i++){
			for(int j=0;j<ar_size;j++){
				ar[i][j] = Integer.parseInt(buffer.readLine());;
			}
		}
		int result = hourglassSum(ar);
        System.out.println("\nMaximum Sum = "+result);
        buffer.close();
    }
}