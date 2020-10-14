package Hacker;
import java.util.Scanner;
class Anagram_Count
{
	public int anagram_count(String word,String text)
	{
		int word_size=word.length();
		int text_size=text.length();
		
		int word_ar[]=new int[word_size];
		int text_ar[]=new int[text_size];
		
		char word_chr[]=word.toCharArray();
		char text_chr[]=text.toCharArray();
		
		for(int i=0;i<word_size;i++)
		{
			word_ar[i]=word_chr[i];
		}
		
		for(int i=0;i<text_size;i++)
		{
			text_ar[i]=text_chr[i];
		}
		
		int count=0;
		
		for(int i=0;i<text_size;i++)
		{
			count+=text_ar[i];
		}
		
		int count1=0,count2=0,temp=0;
		for(int i=0;i<word_size-text_size+1;i++)
		{
			int j=i;
			while(count1<text_size)
			{
				count2+=word_ar[j];
				count1++;
				j++;
			}
			if(count==count2)
			{
				temp++;
			}
			count1=0;
			count2=0;
		}
		
		return temp;
	}
	
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Word : ");
		String word=sc.nextLine();
		System.out.println("Enter Text : ");
		String text=sc.nextLine();
		
		Anagram_Count d = new Anagram_Count();
		
		int count=d.anagram_count(word,text);
		System.out.println("Anagram of "+text+" present "+count+"times in the "+word);
		sc.close();
	}
}
