import java.io.*;
public class FileWriterExample {
    static final PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) throws IOException{
        String source = "Now is the time for all good men\n"
        + " to come to the aid of their country\n"
        + " and pay their due taxes. Ali Hasan";
        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        //FileWriter fileWriter = new FileWriter("../InputJava.txt");
        //this FileWriter("file1.txt") will create a file in same drectory if file is not available and write the data in file 
        //If we want to append the data at the end of file use FileWriter("File1.txt",true)
        FileWriter fileWriter = new FileWriter("../InputJava.txt",true);
        // for (int i = 0; i < buffer.length; i++) {
        //     fileWriter.write(buffer[i]);
        // }

        fileWriter.write(source);
        fileWriter.close();
    }
}
