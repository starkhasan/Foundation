public class SummingSum {
    public static int summation(int number){
        if(number == 1){
            return 1;
        }else{
            return number+summation(number-1);
        }
    }
    public static int series(int N,int M,int K){
        while(M>0){
            int temp = summation(K+N);
            temp = temp*2;
            N = temp;
            M = M-1;
        }
        return N;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        boolean isFirst = true;
        boolean isSecond = true;
        int L = 0;
        int R = 0;
        int X = 0;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                L = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                R = Integer.parseInt(buffer.readLine());
            }else{
                X = Integer.parseInt(buffer.readLine());
            }
        }
        int result = series(L,R,X);
        System.out.println(result);
        buffer.close();
    }
}
