package Hashing;
import java.io.*;
import java.util.*;
class HashChaining{
    int SIZE;
    ArrayList<Integer>[] lists;
    HashChaining(int SIZE){
        this.SIZE = SIZE;
        lists = new ArrayList[SIZE];
        for(int i=0;i<SIZE;i++){
            lists[i] = new ArrayList<Integer>();
        }
    }

    int hashFunction(int item){
        return item%SIZE;
    }

    void insert(int item){
        int index = hashFunction(item);
        lists[index].add(item);
    }

    void dislayHash(){
        for(int i=0;i<SIZE;i++){
            if(lists[i]!=null && lists[i].size()>0)
                System.out.println(lists[i]);
        }
    }

    boolean delete(int item){
        int index = hashFunction(item);
        if(lists[index].contains(item)){
            for(int i=0;i<lists[index].size();i++){
                if(lists[index].get(i) == item)
                    lists[index].remove(i);
            }
            return true;
        }else{
            return false;
        }
    } 
}
public class SeparateChaining {
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputSeparateChaining.txt"));
        int size=0,input_delete=0;
        boolean First = true , Second = true,Third = true;
        String input_Ar="",input_insert="";
        while((buffer.readLine())!=null){
            if(First){
                First = false;
                size = Integer.parseInt(buffer.readLine());
            }else if(Second){
                Second = false;
                input_Ar = buffer.readLine();
            }else if(Third){
                Third = false;
                input_insert = buffer.readLine();
            }else{
                input_delete = Integer.parseInt(buffer.readLine());
            }
        }
        String[] strAr = input_Ar.split(" ");
        int[] Ar = new int[strAr.length];
        for(int i=0;i<strAr.length;i++){
            Ar[i] = Integer.parseInt(strAr[i]);
        }
        String[] strInsert = input_insert.split(" ");
        int[] Ar_insert = new int[strInsert.length];
        for(int i=0;i<strInsert.length;i++){
            Ar_insert[i] = Integer.parseInt(strInsert[i]);
        }
        HashChaining hash = new HashChaining(size);
        for(int i=0;i<Ar.length;i++){
            hash.insert(Ar[i]);
        }
        hash.dislayHash();
        if(hash.delete(input_delete)){
            System.out.println("\n"+input_delete+" Remove Item Successfully");
            hash.dislayHash();
        }else
            System.out.println("\n"+input_delete+" not found");

        System.out.println("\nAdding More Element in Hash Table");
        for(int i=0;i<Ar_insert.length;i++){
            hash.insert(Ar_insert[i]);
        }
        hash.dislayHash();
        buffer.close();
    }   
}
