class Outer{
  private static void outerMethod(){
    System.out.println("Inside outerMethod");
  }
  static class Inner{
    public static void main(String[] args) {
      System.out.println("Inside inner class method");
      outerMethod();
    }
  }
}
