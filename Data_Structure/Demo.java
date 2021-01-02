import java.util.*;
class Demo{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();
    if(year%4 == 0){
      System.out.println(year+" is Leap");
    }else if((year%4==0) && (year%100!=0)){
      System.out.println(year+" is Leap");
    }else{
      System.out.println(year+" is not Leap");
    }
  }
}