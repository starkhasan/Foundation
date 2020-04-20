import java.util.Scanner;
/*class Demo{

    Node head;
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Linked List : ");
        int listSize = sc.nextInt();
        System.out.println("Enter the Element in Linked List : ");
        for(int i=0;i<listSize;i++){
            d.insert(sc.nextInt());
        }
        d.display();
        sc.close();
    }
}
*/
/*
class Demo{

    Node root;
    class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public void insert(int values){
        if(root == null ){
            root = new Node(values);
            return;
        }else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(values <= focusNode.data){
                    focusNode=focusNode.left;
                    if(focusNode==null){
                        parent.left=new Node(values);
                        return;
                    }
                }else{
                    focusNode=focusNode.right;
                    if(focusNode==null){
                        parent.right=new Node(values);
                        return;
                    }
                }
            }
        }
    }

    public void printInorder(Node head){
        if(head!=null){
            printInorder(head.left);
            System.out.print(head.data+" ");
            printInorder(head.right);
        }
    }

    public void printPostOrder(Node head){
        if(head!=null){
            printPostOrder(head.left);
            printPostOrder(head.right);
            System.out.print(head.data+" ");
        }
    }

    public void printPreOrder(Node head){
        if(head!=null){
            System.out.print(head.data+" ");
            printPreOrder(head.left);
            printPreOrder(head.right);
        }
    }

    public int height(Node focusNode){
        if(focusNode == null){
            return 0;
        }
        int leftDepth = height(focusNode.left);
        int rightDepth = height(focusNode.right);
        int max=0;
        if(leftDepth>rightDepth){
            max = leftDepth+1;
        }else{
            max = rightDepth+1;
        }

        return max;
    }
    
    public void BFS(Node focusNode){
        for(int i=1;i<=height(focusNode);i++){
            printlevel(focusNode,i);
        }
    }

    public void printlevel(Node levelNode,int level){
        if(levelNode == null ){
            return;
        }
        if(level==1){
            System.out.print(levelNode.data+" ");
        }else if(level>1){
            printlevel(levelNode.left, level-1);
            printlevel(levelNode.right, level-1);
        }
    }

    public void DFS(Node fousNode){
        if(fousNode!=null){
            System.out.print(fousNode.data+" ");
            DFS(fousNode.left);
            DFS(fousNode.right);
        }
    }
    static int countLeaf;
    public void treeLeafe(Node focusNode){
        if(focusNode == null){
            countLeaf=0;
        }else{
            if(focusNode.left==null && focusNode.right==null){
                countLeaf += countLeaf + 1;
            }
            treeLeafe(focusNode.left);
            treeLeafe(focusNode.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Demo d=new Demo();
        System.out.println("Enter the Size of the Binary Tree : ");
        int tree_size = sc.nextInt();
        System.out.println("Enter the Element in Tree : ");
        for(int i=0;i<tree_size;i++){
            d.insert(sc.nextInt());
        }
        d.printInorder(d.root);
        System.out.println();
        d.printPostOrder(d.root);
        System.out.println();
        d.printPreOrder(d.root);
        int heightofTree = d.height(d.root);
        System.out.println("\nHeight of Binary Tree is "+heightofTree);
        System.out.println("\nBreadth First Search : ");
        d.BFS(d.root);
        System.out.println("\nDepth First Search : ");
        d.DFS(d.root);
        d.treeLeafe(d.root);
        //Using BFS (Breadth First Search) Srach particular Item in the Binary Search Tree
        int searchElement = sc.nextInt();
        sc.close();
    }
}
*/
/*
class Demo{

    public int[] sort(int a[]){
        int ar_length = a.length;
        int key=0;
        for(int j=1;j<ar_length;j++){
            key = a[j];
            int i=j-1;
            while(i>=0 && a[i]>key){
                a[i+1]=a[i];
                i=i-1;
            }
            a[i+1]=key;
        }

        return a;
    }

    public void printElement(int a[]){
        System.out.println("Sorted Array : ");
        int ar_length = a.length;
        for(int i=0;i<ar_length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int ar_size = sc.nextInt();
        int[] ar=new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i] = sc.nextInt();
        }
        ar = demo.sort(ar);
        demo.printElement(ar);
        sc.close();
        
    }
}
*/

/*
//Merge Sorting Algorithm
class Demo{

    public void merge(int a[],int p,int q,int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i] = a[p+i];
        }
        for(int i=0;i<n2;i++){
            rightArray[i] = a[q+1+i];
        }
    
    
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
        a[k] = leftArray[i];
        i++;
        k++;
        }

        while (j < n2) {
        a[k] = rightArray[j];
        j++;
        k++;
        }
    }

    public void mergeSort(int a[],int p,int r){
        int q;
        if(p<r){
            q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a,p,q,r);
        }
    }
    public static void main(String[] args) {
        Demo d=new Demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int ar_size = sc.nextInt();
        int[] ar=new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }
        d.mergeSort(ar, 0, ar.length-1);
        System.out.println();
        System.out.println("Sorted Array : ");
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
        sc.close();
    }
}
*/

/*
// BUbble sorting
class Demo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the Array : ");
        int ar_size = sc.nextInt();
        int ar[]=new int[ar_size];
        System.out.println("Enter the in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }

        //Performing bubble Sorting Algorithm  : 
        int temp=0;
        for(int i=0;i<ar_size;i++){
            for(int j=0;j<ar_size-1;j++){
                if(ar[j]>ar[j+1]){
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }


        System.out.println("Sorted Array : ");
        for(int i=0;i<ar_size;i++){
            System.out.print(ar[i]+" ");
        }
    }
}*/
/*
class Demo{

    public void quickSort(int ar[],int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar,p,q-1);
            quickSort(ar,q+1,r);
        }
    }

    public int partition(int ar[],int p,int r){
        int x = ar[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(ar[j]<=x){
                i = i+1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int ar_size = sc.nextInt();
        int ar[] = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i] = sc.nextInt();
        }
        demo.quickSort(ar,0,ar_size-1);
        for(int i=0;i<ar_size;i++){
            System.out.print(ar[i]+" ");
        }
        sc.close();
    }
}
*/
/*
//Selection Sort
class Demo{

    public void selectionSort(int ar[]){
        int ar_size = ar.length;
        int min=0,pos=0;
        for(int i=0;i<ar_size;i++){
            min = ar[i];
            pos = i;
            for(int j=i;j<ar_size;j++){
                if(min>ar[j]){
                    min = ar[j];
                    pos = j;
                }
            }
            int temp = ar[i];
            ar[i] = min;
            ar[pos] = temp;
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int ar_size = sc.nextInt();
        int[] ar = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i] = sc.nextInt();
        }
        demo.selectionSort(ar);
        System.out.println("Sorted Array : ");
        for(int i=0;i<ar_size;i++){
            System.out.print(ar[i]+" ");
        }
    }
}
*/

/*
//Binary Search
class Demo{

    public int partition(int ar[],int p,int r){
        int x = ar[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(ar[j]<=x){
                i=i+1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }
    public void quickSort(int ar[],int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    public int binarySearch(int ar[],int p,int r,int search_element){
        if(p<=r){
            int mid = (p+r)/2;
            if(ar[mid] == search_element){
                return mid;
            }
            if(ar[mid] > search_element){
                return binarySearch(ar, p, mid-1, search_element);
            }
            if(ar[mid] < search_element){
                return binarySearch(ar, mid+1, r, search_element);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Demo d=new Demo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of the Array : ");
        int ar_size = sc.nextInt();
        int ar[] = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i]=sc.nextInt();
        }
        d.quickSort(ar,0,ar_size-1);
        System.out.println("Enter the Element Do you want to Search : ");
        int search_element = sc.nextInt();
        int result = d.binarySearch(ar,0,ar_size-1,search_element);
        if(result==-1){
            System.out.println(search_element+" Not Found in the List");
        }else{
            System.out.println(search_element+" Found at Position "+(result+1));
        }
        sc.close();
    }
}
*/
