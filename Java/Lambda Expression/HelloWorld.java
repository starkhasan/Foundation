interface HelloWorld{
    void print();
}
class demo{
    public static void main(String[] args) {
        HelloWorld helloWorld;
        helloWorld = () -> {
            System.out.println("Hello World!");
        };
        helloWorld.print();
    }
}