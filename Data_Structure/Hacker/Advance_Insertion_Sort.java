/*
In Insertion Sort Part 1, you inserted one element into an array at its correct sorted position. Using the same approach repeatedly, can you sort an entire array?
Guideline: You already can place an element into a sorted array. How can you use that code to build up a sorted array, one element at a time?
Note that in the first step, when you consider an array with just the first element, it is already sorted since there's nothing to compare it to.
In this challenge, print the array after each iteration of the insertion sort, i.e., whenever the next element has been inserted at its correct position.
Since the array composed of just the first element is already sorted, begin printing after placing the second element.

For example, n=7 there are elements in arr=[3,4,7,5,6,2,1] . Working from left to right, we get the following output:

3 4 7 5 6 2 1
3 4 7 5 6 2 1
3 4 5 7 6 2 1
3 4 5 6 7 2 1
2 3 4 5 6 7 1
1 2 3 4 5 6 7

Sample Input:-
6
1 4 3 5 6 2

Sample Output:-
1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 
*/
package Hacker;
import java.util.*;
public class Advance_Insertion_Sort {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr)
    {
        int ar_size=arr.length;
        int key=0,k=0;
        for(int j=1;j<ar_size;j++)
        {
            key=arr[j];
            int i=j-1;
            while(i>=0 && arr[i]>key)
            {
                arr[i+1]=arr[i];
                i-=1;
            }
            arr[i+1]=key;

            for(k=0;k<ar_size;k++)
            {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);
        scanner.close();
    }
}
