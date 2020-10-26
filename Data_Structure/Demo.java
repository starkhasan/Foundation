import java.io.*;
public class Demo{
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Bucket Capacity : ");
        int bucketCapacity = Integer.parseInt(buffer.readLine());
        System.out.print("\nEnter Mug Capacity : ");
        int mugCapavity = Integer.parseInt(buffer.readLine());
        boolean isFull = true;
        int count = 1;
        int perCapcity = (bucketCapacity - ((100 * 20)/100));
        System.out.println();
        if(mugCapavity > bucketCapacity){
            System.out.println("INVALID INPUT");
        }else{
            int tempMug  = 0;
            while(isFull){
                int water = Integer.parseInt(buffer.readLine());
                if(water > mugCapavity || water < 0){
                    System.out.println("INVALID INPUT");
                    break;
                }
                tempMug+=water;
                if(perCapcity <= tempMug){
                    System.out.println("BUCKET FULL!");
                    System.out.println("NUMBER OF MUGS:"+count);
                    break;
                }
                count++;
            }
        }
    }
}
