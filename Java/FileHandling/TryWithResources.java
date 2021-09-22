import java.io.*;
public class TryWithResources {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("../InputJava.txt",true)) {
            String fileContent = "Append this in InputJava.txt for Checking try-with-resources";
            fileWriter.write(fileContent);            
        } catch (IOException e) {
            new PrintWriter(System.out,true).println(e.getMessage());
        }
    }
}
