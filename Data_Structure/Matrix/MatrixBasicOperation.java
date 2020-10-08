import java.util.*;
import java.io.*;
public class MatrixBasicOperation {
    final static Scanner sc = new Scanner(System.in);
    static void insert(int[][] A,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j] = sc.nextInt();
            }
        }
    }
    static int[][] addition(int[][] A,int[][] B){
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                A[i][j] = A[i][j] + B[i][j];
            }
        }
        return A;
    }
    static void printMatrix(int[][] A){
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void printArray(int[] A){
        for(int i=0;i<A.length;i++)
            System.out.print(A[i]+" ");
    }
    static int[][] multiplication(int[][] A,int[][] B){
        int[][] mul = new int[A[0].length][A[0].length];
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                mul[i][j] = 0;
                for(int k=0;k<A[0].length;k++){
                    mul[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return mul;
    }
    static int[][] traspose(int[][] A){
        int[][] trans = new int[A[0].length][A[0].length];
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                trans[i][j] = A[j][i];
            }
        }
        return trans;
    }
    static int[][] scalar_product(int[][] B,int number){
        int[][] temp = new int[B[0].length][B[0].length];
        for(int i=0;i<B[0].length;i++){
            for(int j=0;j<B[0].length;j++){
                temp[i][j] = number * B[i][j];
            }
        }
        return temp;
    }
    static int[][] sortMatrix(int[][] A){
        int[] temp = new int[A[0].length*A[0].length];
        int k = 0;
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                temp[k++] = A[i][j];
            }
        }
        Arrays.sort(temp);
        k = 0;
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                A[i][j] = temp[k++];
            }
        }
        return A;
    }

    static int[][] rotate90(int[][] A){
        int[][] temp = new int[A[0].length][A[0].length];
        int k = 0;
        for(int i=0;i<A.length;i++){
            k = A[0].length;
            for(int j=0;j<A.length;j++){
                temp[i][j] = A[k-1-j][i];
            }
        }
        return temp;
    }
    static int[] rowMaxElement(int[][] A){
        int[] temp = new int[A.length];
        int max = 0;
        for(int i=0;i<A[0].length;i++){
            max = 0;
            for(int j=0;j<A[0].length;j++){
                if(j == 0)
                    max = A[i][j];
                else if(max < A[i][j])
                    max = A[i][j];
            }
            temp[i] = max;
        }
        return temp;
    }
    static List<Integer> duplicateElement(int[] A){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
            if(!list.contains(A[i]))
                list.add(A[i]);
        }
        return list;
    }
    static void uniqueElement(int[][] A){
        int[] temp = new int[A[0].length*A[0].length];
        int k = 0;
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                temp[k++] = A[i][j];
            }
        }
        List<Integer> tempList = duplicateElement(temp);
        if(tempList.size()>0){
            Iterator iterator = tempList.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
        }else
            System.out.println("No unique element in the matrix");
    }

    static int[][] interchange(int[][] A){
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length;j++){
                if(i==j){
                    int col_pos = (A[0].length-1)-i;
                    int temp = A[i][j];
                    A[i][j] = A[i][col_pos];
                    A[i][col_pos] = temp;
                }
            }
        }
        return A;
    }

    static void printSnack(int[][] A){
        int j = 0;
        for(int i=0;i<A[0].length;i++){
            if(i%2==0){
                for(j=0;j<A[0].length;j++)
                    System.out.print(A[i][j]+" ");
            }else{
                for(j=A[0].length-1;j>=0;j--)
                    System.out.print(A[i][j]+" ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Size of Matrix : ");
        int n = sc.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        System.out.println("Enter Element in First Matrix : ");
        insert(A,n);
        System.out.println("Enter Element in Second Matrix : ");
        insert(B,n);
        A = addition(A,B);
        System.out.println("\nResult of Matrix : ");
        printMatrix(A);
        int[][] C = new int[n][n];
        System.out.println("\nMultiplication Matrix : ");
        C = multiplication(A,B);
        printMatrix(C);
        System.out.println("\nTraspose Matrix : ");
        int[][] trans = new int[n][n];
        trans = traspose(A);
        printMatrix(trans);
        System.out.println("Enter Number for Scalar Product : ");
        int number = sc.nextInt();
        int[][] scal_prod = new int[n][n];
        scal_prod = scalar_product(B, number);
        printMatrix(scal_prod);
        System.out.println("\nSort Matrix : ");
        scal_prod = sortMatrix(scal_prod);
        printMatrix(scal_prod);
        System.out.println("\nRotate 90 degree of Matrix : ");
        printMatrix(rotate90(scal_prod));
        System.out.println("\nRotate 180 degree of Matrix : ");
        int[][] temp = rotate90(scal_prod);
        printMatrix(rotate90(temp));
        System.out.println("\nMaximum Element of each row : ");
        int row[] = rowMaxElement(C);
        printArray(row);
        System.out.println("\nPrint Unique Element in Matrix");
        uniqueElement(B);
        System.out.println("\nInterchange Diagonal Matrix");
        int[][] diagonal = interchange(C);
        printMatrix(diagonal);
        System.out.println("\nSnack Print Matrix : ");
        printSnack(diagonal);
        
    }
}
