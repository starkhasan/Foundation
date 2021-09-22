import java.io.*;
public class FileReaderExample{
  static final PrintWriter printWriter = new PrintWriter(System.out,true);
  public static void main(String[] args) throws IOException{
    /**
     * FileReader class create a Reader that you can use to read the content of a file.
     * It's two most commonly used constructor
     * FileReader(String filePath)
     * FileReader(File fileObj)
     */
    File file = new File("../InputJava.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String s = "";
    while((s = bufferedReader.readLine()) != null){
      printWriter.println(s);
    }
    fileReader.close();
  }
}
