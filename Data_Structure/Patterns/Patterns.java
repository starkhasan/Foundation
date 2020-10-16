package Patterns;
import java.io.*;
public class Patterns{
    public static void pyramidPattern(int n) {
        for(int i=0;i<n;i++){
            int k = 0;
            while(k<(n-i)){
                System.out.print(" ");
                k++;
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }  
    }
    public static void rightTriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void leftTriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<n-1-i)
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void diamondShape(int n){
        int k=0;
        for(int i=0;i<n;i++){
            k = 0;
            while(k<(n-i)){
                System.out.print(" ");
                k++;
            }
            int j=0;
            while(j<(i*2+1)){
                System.out.print("*");
                j++;
            }
            System.out.println();
        }
        int q = n;
        for(int i=0;i<n-1;i++){
            q = q - 1;
            k = 0;
            while(k<=i+1){
                System.out.print(" ");
                k++;
            }
            for(int j=0;j<(q*2-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void downwardTriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<n-i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void reversePyramid(int n){
        int k = 0;
        for(int i=0;i<n;i++){
            System.out.print(" ");
            k=0;
            while(k<i){
                System.out.print(" ");
                k++;
            }
            for(int j=0;j<n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void rightDownMirrorStar(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void rightPascalTriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(j<n-i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void leftPascalTriangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<n-1-i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n-1;i++){
            System.out.print(" ");
            for(int j=0;j<n-1;j++){
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void sandGlass(int n){
        reversePyramid(n);
        pyramidPattern(n);
    }
    public static void triangleStar(int n){
        int k=0;
        for(int i=0;i<n;i++){
            k = 0;
            while(k<(n-i)){
                System.out.print(" ");
                k++;
            }
            if(i<n-1){
                int j=0;
                while(j<(i*2+1)){
                    if(j==0 || j==(i*2))
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    j++;
                }
            }else{
                int q=0;
                for(;q<n;q++)
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputPattern.txt"));
        int n = 0;
        while((buffer.readLine())!=null){
            n = Integer.parseInt(buffer.readLine());
        }
        pyramidPattern(n);
        rightTriangle(n);
        leftTriangle(n);
        diamondShape(n);
        downwardTriangle(n);
        reversePyramid(n);
        rightDownMirrorStar(n);
        rightPascalTriangle(n);
        leftPascalTriangle(n);
        sandGlass(n);
        triangleStar(n);
        buffer.close();
    }
}