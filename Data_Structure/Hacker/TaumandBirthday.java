package Hacker;
import java.io.*;
public class TaumandBirthday {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        int tempbc = 0,tempwc = 0;
        if((bc+z)<=wc)
            tempwc = bc+z;
        else
            tempwc = wc;
        if((wc+z)<=bc)
            tempbc = wc+z;
        else
            tempbc = bc;
        long totalbc = (long)tempbc*(long)b;
        long totalwc = (long)tempwc*(long)w;
        return totalbc+totalwc;    
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            long result = taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
