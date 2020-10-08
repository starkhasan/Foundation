//Bitset class create a special type of the array that holds values in the form of boolean values
//this array can increse in size as needed
//two constructor
//1 BitSet()
//2 BitSet(int size)
import java.util.*;
class demo
{
    public static void main(String [] args)
    {
        BitSet bit1=new BitSet(16);
        BitSet bit2=new BitSet(16);
        for(int i=0;i<16;i++)
        {
            if(i%2==0)
            bit1.set(i);
            else
            bit2.set(i);
        }
        System.out.println("Bit1 : "+bit1+"\nBit2 : "+bit2);
    }
}