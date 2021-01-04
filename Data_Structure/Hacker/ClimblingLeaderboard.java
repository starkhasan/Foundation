import java.io.*;
import java.util.*;
public class ClimblingLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> rank, List<Integer> player) {
        List<Integer> result = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>(rank);
        rank.clear();
        rank.addAll(set);  
        Collections.sort(rank);
        Collections.reverse(rank); 
        System.out.println(rank);
        int i = rank.size()-1;
        for(int element :  player){
            while(i>=0){
                if(element >= rank.get(i)){
                    i-=1;
                }else{
                    result.add(i+2);
                    break;
                }
            }
            if(i<0)
                result.add(1);
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputHacker.txt"));
        List<Integer> rankedList,playerList;
        Boolean isFirst = true;
        String player = "",ranked = "";
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                ranked = buffer.readLine();
            }else{
                player = buffer.readLine();
            }
        }
        rankedList = new ArrayList<>();
        playerList = new ArrayList<>();
        for(int i=0;i<ranked.split(" ").length;i++){
            rankedList.add(Integer.parseInt(ranked.split(" ")[i]));
        }
        for(int i=0;i<player.split(" ").length;i++){
            playerList.add(Integer.parseInt(player.split(" ")[i]));
        }
        
        List<Integer> newList = climbingLeaderboard(rankedList,playerList);
        for(int i=0;i<newList.size();i++){
            System.out.println(newList.get(i));
        }
        buffer.close();
    }
}
