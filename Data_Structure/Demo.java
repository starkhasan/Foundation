import java.io.*;
public class Demo{
    static boolean isPrime(int number){
        boolean result = true;
        for(int i=2;i<=number/2;i++){
            if(number%i == 0){
                result  = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number : ");
        int number = Integer.parseInt(buffer.readLine());
        String result = isPrime(number)?"Prime NUmber":"Not Prime";
        System.out.println(result);
        /*System.out.println("Enter Day : ");
        String day = buffer.readLine();
        String result = switch (day) {
            case "M", "W", "F" -> {
                yield "monday";
            }
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }
 
        };
        System.out.println(result);*/
        buffer.close();
    }
}