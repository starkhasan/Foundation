import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CatMouse {
    static String catAndMouse(int x, int y, int z) {
        int first = Math.abs(z-x);
        int second = Math.abs(z-y);
        if(first < second){
            return "Cat A";
        }else if(first > second){
            return "Cat B";
        }else{
            return "Mouse C";
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        while((buffer.readLine())!=null){
            String[] strAr = buffer.readLine().split(" ");
            int x = Integer.parseInt(strAr[0]);
            int y = Integer.parseInt(strAr[1]);
            int z = Integer.parseInt(strAr[2]);
            System.out.println(catAndMouse(x, y, z));
        }
        buffer.close();
    }
}
