package Hacker;
import java.io.*;
import java.util.*;
public class ClimblingLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        for(int i=0;i<ranked.size();i++){
            if(!rank.contains(ranked.get(i)))
                rank.add(ranked.get(i));
        }   
        Collections.reverse(player);
        //System.out.println("Temp = "+player);
        //System.out.println("Rank = "+rank);
        int matchPositoion = 0,j = 0,temp = 0;
        for(int i=0;i<player.size();i++){
            temp = player.get(i);
            j = matchPositoion;
            //System.out.println("Pos = "+j+" Temp = "+temp);
            while(j<rank.size()){
                if(temp > rank.get(j) || temp == rank.get(j)){
                    matchPositoion = j;
                    break;
                }else if(temp < rank.get(j)){
                    if(j+1 == rank.size()){
                        matchPositoion = j+1;
                        break;
                    }
                }
                j+=1;
            }
            //System.out.println(matchPositoion);
            result.add(matchPositoion+1);
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
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
