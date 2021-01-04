import java.util.*;
class Demo{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String heystack = sc.nextLine();
    String needle = sc.nextLine();
    if(needle.isEmpty()){
      System.out.println(0);
    }else if(heystack.isEmpty()){
      System.out.println(0);
    }else if(!heystack.contains(needle)){
      System.out.println(-1);
    }else{
      int pos=  heystack.indexOf(needle);
      System.out.println(pos);
    }
  }
}