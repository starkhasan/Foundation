package Hacker;
import java.io.*;
import java.util.*;
public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for(int i=0;i<grades.size();i++){
            if(grades.get(i) >= 38 && grades.get(i)%5 >= 3){
                grades.set(i,(((grades.get(i)/5)+1)*5));
            }
        }
        return grades;
    }
	public static void main(String [] args)throws IOException{
		List<Integer> grades = new ArrayList<>();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Array : ");
		String[] strArray = buffer.readLine().split(" ");
		for(int i=0;i<strArray.length;i++){
			grades.add(Integer.parseInt(strArray[i]));
		}
		grades = gradingStudents(grades);
		Iterator itr = grades.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
        }
        buffer.close();
	}
}
