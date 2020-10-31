import java.util.*;
import java.io.*;
class GFG{
    int minEle;
    Stack<Integer> stack = new Stack<Integer>();
    int getMin(){
        if(stack.size()>0){
            for(int i=0;i<stack.size();i++){
                if(i==0)
                    minEle = stack.get(i);
                else if(minEle > stack.get(i))
                    minEle = stack.get(i);
            }
            return minEle;
        }else{
            return -1;
        }
    }
    int pop(){
        if(stack.size()>0)
            return stack.pop();
        else
            return -1;
    }
    void push(int x){
        stack.push(x);
    }
}
public class StackOperation {
    public static void main(String[] args) throws IOException{  
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        GFG obj = new GFG();
        while((buffer.readLine())!=null){
            String[] strAr = buffer.readLine().split(" ");
            if(strAr.length>1){
                obj.push(Integer.parseInt(strAr[1]));
            }else{
                int result = 0;
                if(Integer.parseInt(strAr[0]) == 3){
                    result = obj.getMin();
                }
                if(Integer.parseInt(strAr[0]) == 2){
                    result = obj.pop();
                }
                System.out.print(result+" ");
            }
        }
        buffer.close();
    }
}
