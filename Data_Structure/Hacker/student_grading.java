package Hacker;
import java.io.*;
import java.util.*;


class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades)
    {
      int size=grades.length;
      for(int i=0;i<size;i++)
    {

       if(grades[i]<38)
       {
         //System.out.print(a[i]+" ");
         grades[i]=grades[i];
       }
       else
       {
         int temp=grades[i]%10;
         if(temp<5)
         {
           temp=5-temp;
           if(temp<3)
           {
             //System.out.print((a[i]+temp)+" ");
             grades[i]=grades[i]+temp;
           }
           else
           {
             //System.out.print(a[i]+" ");
             grades[i]=grades[i];
           }
         }

         if(temp>5)
         {
           //System.out.print(temp);
           temp=10-temp;
           //System.out.print(temp);
           if(temp<3)
           {
             //System.out.print((a[i]+temp)+" ");
             grades[i]=grades[i]+temp;
           }
           else
           {
             //System.out.print(a[i]+" ");
             grades[i]=grades[i];
           }
         }

         if(temp==5)
         {
           //System.out.print(a[i]+" ");
           grades[i]=grades[i];
         }
       }

     }
        /*
         * Write your code here.
         */
         return grades;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
