public class SortedSubSegment {
    static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i = p - 1;
        for(int j=p;j<r;j++){
            if(ar[j] < key){
                i+=1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] =temp;
        return i+1;
    }
    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1,r);
        }
    }
    static int sortedSubsegments(int k, int[] a, int[][] queries) {
        int[] temp = a.clone();
        quickSort(temp, 0, temp.length-1);
        for(int i=0;i<queries.length;i++){
            if(!Arrays.equals(temp,a)){
                quickSort(a,queries[i][0],queries[i][1]);
            }else{
                break;
            }
        }
        return a[k];
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputDemo.txt"));
        String first = "",second = "";
        int k = 0;
        boolean isFirst = true,isSecond = true;
        while((buffer.readLine())!=null){
            if(isFirst){
                isFirst = false;
                k = Integer.parseInt(buffer.readLine());
            }else if(isSecond){
                isSecond = false;
                first = buffer.readLine();
            }else{
                second = buffer.readLine();
            }
        }
        String[] strA = first.split(" ");
        int[] inputArray = new int[strA.length];
        for(int i=0;i<strA.length;i++)
            inputArray[i] = Integer.parseInt(strA[i]);
        String[] strB = second.split(",");
        int[][] query = new int[strB.length][2];
        for(int i=0;i<strB.length;i++){
            String[] temp = strB[i].split(" ");
            for(int j=0;j<2;j++){
                query[i][j] = Integer.parseInt(temp[j]);
            }
        }
        System.out.println(sortedSubsegments(k,inputArray,query));
        buffer.close();
    }
}
