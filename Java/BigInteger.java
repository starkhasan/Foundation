import java.math.BigInteger;
import java.util.Scanner;
class demo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger number = new BigInteger(sc.next());
        if(number.isProbablePrime(1)){
            System.out.print("pRime");
        }else{
            System.out.print("not prime");
        }
        number =  number.multiply(BigInteger.valueOf(12));
        System.out.println(number);
        BigInteger bitInt[] = number.divideAndRemainder(BigInteger.valueOf(2));
        BigInteger value = bitInt[0];
        BigInteger remainder = bitInt[1];
        System.out.println("Value  = "+value+" Remainder = "+remainder);
        
        for (BigInteger a = BigInteger.TWO; a.compareTo(BigInteger.valueOf(10)) <= 0; a = a.add(BigInteger.ONE)){
            System.out.print(a.compareTo(BigInteger.valueOf(10)));
            System.out.println(a);
        }
        sc.close();
    }
}