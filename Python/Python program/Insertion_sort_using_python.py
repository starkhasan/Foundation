#program for insetion sorting using function
def insertion_sort(n,list2):
    key=0
    for j in range(1,n):
        key=list2[j]
        i=j-1
        while i>=0 and list2[i]>key:
            list2[i+1]=list2[i]
            i-=1
        list2[i+1]=key
    
    for i in range(0,n):
        print(list2[i],end=" ")


n=int(input("Enter Size : "))
list1=[]
print("Enter Element in list : ")
for i in range(0,n):
    list1.append(int(input()))

insertion_sort(n,list1)