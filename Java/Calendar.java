//calender program
import java.util.*;
public class Calendar{
    static boolean Validation(String _day){
        if("SUNDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("MONDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("TUESDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("WEDNESDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("THURSDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("FRIDAY".equalsIgnoreCase(_day)){
            return true;
        }else if("SATURDAY".equalsIgnoreCase(_day)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String [] args){
        System.out.println("Author : Ali Hasan");
        Scanner sc=new Scanner(System.in);
        while(true){
            try{
                System.out.print("\nEnter First Day : ");
                String _day = sc.nextLine();
                boolean isValid = Validation(_day.toUpperCase());
                if(!isValid)
                    throw new NumberFormatException("Please Enter Valid Day");
                int first_day = 0;
                switch(_day.toUpperCase()){
                    case "SUNDAY":
                        first_day = 1;
                        break;
                    case "MONDAY":
                        first_day = 2;
                        break;
                    case "TUESDAY":
                        first_day = 3;
                        break;
                    case "WEDNESDAY":
                        first_day = 4;
                        break;
                    case "THURSDAY":
                        first_day = 5;
                        break;
                    case "FRIDAY":
                        first_day = 6;
                        break;
                    case "SATURDAY":
                        first_day = 7;
                        break;
                } 
                System.out.print("\nEnter Total Days (28-31): ");
                int total_day=sc.nextInt();   
                if(total_day<28 || total_day>31)
                    throw new NumberFormatException("Please Enter Valid Total Days in a Month");
                int count=1;
                System.out.println("\nSUN  \tMON  \tTUE  \tWED  \tTHU  \tFRI  \tSAT");
                for(int i=0;i<6;i++){
                    for(int j=0;j<7;j++){
                        if(count>total_day)
                        break;
                        if(i==0){
                            if(j<first_day-1)
                                System.out.print("  \t");
                            else{
                                System.out.printf("%2d\t",count);
                                count++;
                            }
                        }
                        if(i>0){
                            if(j<7){
                                System.out.printf("%2d\t",count);
                                count++;
                            }
                            else
                                System.out.print("   ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Do you want to continue? (Y/N)");
                if(sc.next().charAt(0) == 'n'){
                    System.out.println("\nThank you...");
                    break;
                }
                sc.nextLine();
            }catch(NumberFormatException ae){
                System.out.println(ae.getMessage());
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}

