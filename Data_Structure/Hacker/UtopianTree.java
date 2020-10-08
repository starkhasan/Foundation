public class UtopianTree {
    static int utopianTree(int n) {
        int tree_height = 0;
        for(int i=0;i<=n;i++){
            if(i%2==0)
                tree_height+=1;
            else
                tree_height*=2;
        }
        return tree_height;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        int n = 0;
        while((buffer.readLine())!=null){
            n = Integer.parseInt(buffer.readLine());
        }
        System.out.println(utopianTree(n));
        buffer.close();
    }
}
