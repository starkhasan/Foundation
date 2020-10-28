import java.util.*;
public class ListForEach {
    public static void main(String[] args) {
        List<Integer> listNumber = new ArrayList<>();
        int count = 0;
        while(count<5){
            listNumber.add((count+1));
            count+=1;
        }  
        listNumber.forEach( n -> {
            if(n%2==0)
                 System.out.println(n);
        });  
     }
}
