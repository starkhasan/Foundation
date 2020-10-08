import java.io.*;
public class SingleCharacterReading {
    public static void main(String [] args)
    {
        try
        {
            FileReader file=new FileReader("InputFile.txt");
            int ch;
            while(true)
            {
                ch = file.read();
                if(ch==-1)
                    break;
                System.out.print((char)ch);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
