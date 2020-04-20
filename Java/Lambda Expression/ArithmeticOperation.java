interface MyNumber{
    int addition(int a,int b);
}
class demo{
    public static void main(String[] args) {
        MyNumber myNumber;
        myNumber = (a,b) -> {
            return a+b;
        };
        System.out.println("Addition  = "+myNumber.addition(12,12));
    }
}
