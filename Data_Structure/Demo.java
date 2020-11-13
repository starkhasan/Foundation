import java.util.*;
class Demo{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++)
            list.add(i);
        System.out.println(list);

        Integer[] ar = new Integer[list.size()];
        ar = list.toArray(ar);
        for (Integer integer : ar) {
            System.out.println(integer);
        }

        int[] newAr = list.stream().mapToInt(i -> i).toArray();
        for(int j=0;j<newAr.length;j++)
            System.out.print(newAr[j]+" ");
        
        System.out.println(newList);
    }
}