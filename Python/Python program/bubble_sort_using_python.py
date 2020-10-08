#program for bubble sort in python using function
def bubble_sort(n,ar):
    temp=0
    for i in range(0,n):
        for j in range(0,n-1):
            if ar[j] > ar[j+1]:
                temp=ar[j]
                ar[j]=ar[j+1]
                ar[j+1]=temp
    

    for i in range(0,n):
        print(ar[i],end=" ")


n=int(input("Enter size : "))
ar=[]
print("Enter Element : ")
for i in range(0,n):
    ar.append(int(input()))
bubble_sort(n,ar)