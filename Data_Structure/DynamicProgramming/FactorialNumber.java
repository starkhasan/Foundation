public class FactorialNumber {
    final int MAX = 100; 
    final int NIL = 1;
    int lookup[] = new int[MAX];
    
    void initialize(){
        for(int i=0;i<MAX;i++){
            lookup[i] = NIL;
        }
    }

    public int fact(int n){
        if(lookup[n] == NIL){
            if(n<=1){
                lookup[n] = NIL;
            }else{
                lookup[n] = n * fact(n-1);
            }
        }
        return lookup[n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FactorialNumber d = new FactorialNumber();
        d.initialize();
        System.out.println("Enter the Number : ");
        int number = sc.nextInt();
        int result = d.fact(number);
        System.out.println("Result =  "+result);
    }
}
