import java.io.PrintWriter;
import java.util.Scanner;
public class SwitchExample {
    static final PrintWriter pw = new PrintWriter(System.out,true);
    public static String usingifElse(String animal){
        if(animal.equals("Dog") || animal.equals("Cat"))
            return "Domestic Animal";
        else if(animal.equals("Tiger"))
            return "Wild Animal";
        return "Unknown Animal";
    }

    /**
     * We can't pass the null value as an argument to a switch statement. if we do it the program will throw NullPointerException using our firt switch example
     *
     * 
     * @param CaseValues as Compile-time Constants
     * If we try to replace the DOG case value with the variable dog the code won;t compile until we mark the dog variable as final
     * final String dog="DOG";
        String cat="CAT";

        switch (animal) {
        case dog: //compiles
            result = "domestic animal";
        case cat: //does not compile
            result = "feline"
        }
     *
     */
    public static String usingSwitch(String animal){
        String result  = "";
        switch (animal) {
            case "Dog"://Omit break if we want to execute several cases statement
            case "Cat":
                result = "Domestic Animal";
                break;
            case "Tiger":
                result = "Wild Animal";
                break;
            default:
                result = "Unkown Animal";
                break;
                //Only the block where the break statement is not necessary is the last one, but adding a break to the last block makes the code less error prone
        }
        return result;
    }


    public static String usingSwitchExpression(String animal){
        String result = switch (animal) {
           case "Dog","Cat" -> "Domestic Animal";
           case "Tiger" -> "Wild Animal";
           default -> throw new IllegalStateException("Unknown Animal");

        };
        return result;
    }
    /**
     * switch Expression using yield keyword 
     * int numLetters = switch (day) {
        case MONDAY, FRIDAY, SUNDAY -> {
            System.out.println(6);
            yield 6;
        }
        case TUESDAY -> {
            System.out.println(7);
            yield 7;
        }
        case THURSDAY, SATURDAY -> {
            System.out.println(8);
            yield 8;
        }
        case WEDNESDAY -> {
            System.out.println(9);
            yield 9;
        }
        default -> {
            throw new IllegalStateException("Invalid day: " + day);
        }
        }; 
     */
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        pw.println("Enter Animal");
        var result = usingSwitchExpression(scanner.nextLine());
        pw.println(result);   
        scanner.close();
    }
}
