import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CavityMap {
    static String[] cavityMap(String[] grid) {
        String pos = "";
        String[] newGrid = grid.clone();
        boolean isFirst = true;
        for(int i=1;i<grid.length-1;i++){
            pos = "";
            isFirst = true;
            char[] ch = grid[i].toCharArray();
            char[] top = grid[i-1].toCharArray();
            char[] down = grid[i+1].toCharArray();
            for(int j=1;j<ch.length-1;j++){
                if(Integer.parseInt(String.valueOf(ch[j-1])) < Integer.parseInt(String.valueOf(ch[j])) && Integer.parseInt(String.valueOf(ch[j+1])) < Integer.parseInt(String.valueOf(ch[j])) && Integer.parseInt(String.valueOf(ch[j])) > Integer.parseInt(String.valueOf(top[j])) && Integer.parseInt(String.valueOf(ch[j])) > Integer.parseInt(String.valueOf(down[j]))){
                	if(isFirst){
                		isFirst = false;
                		pos = String.valueOf(j);
                	}else
                    	pos = pos+" "+String.valueOf(j);
                }
            }
            if(pos.length()>0){
            	String[] posAr = pos.split(" ");
                for(int k=0;k<posAr.length;k++){
                	ch[Integer.parseInt(posAr[k])] = 'X';
                }
                String newStr = new String(ch);
                newGrid[i] = newStr;
            }
        }

        return newGrid;
    }
	public static void main(String [] args)throws IOException{
		String line="";
		boolean isFirst = true;
		BufferedReader br = new BufferedReader(new FileReader("grid.txt"));
		while((br.readLine()) != null){
			if(isFirst){
				isFirst = false;
				line = br.readLine();
			}else{
				line = line+","+br.readLine();
			}
  		}
		String[] strAr = line.split(",");
		String[] newStr = cavityMap(strAr);
		for(int i=0;i<newStr.length;i++){
			System.out.println(newStr[i]);
		}
	}
}
