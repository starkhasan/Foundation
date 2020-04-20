import java.util.*;
class stringComparision{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String : ");
        String str=sc.nextLine();
        System.out.println("Enter Split Factor : ");
        int splitFactor = sc.nextInt();
        int count=0;
        int strListCount=0;
        String[] strList = new String[str.length()+1-splitFactor];
        for(int i=0;i<=str.length()-splitFactor;i++){
            int j=0;
            String temp="";
            count=i;
            while(j<splitFactor){
                temp = temp + String.valueOf(str.charAt(count));
                j++;
                count++;
            }
            strList[strListCount]=temp;
            strListCount++;
        }

        
        for(int i=0;i<strList.length;i++){
            for(int j=0;j<strList.length-1;j++){
                String temp="";
				if( strList[j].compareTo(strList[j+1]) > 0 ) {
                    temp = strList[j];
                    strList[j]=strList[j+1];
                    strList[j+1]=temp;
                }
            }
        }

        System.out.println(strList[0]+"\n"+strList[strList.length-1]);
        
        sc.close();
    }
}
