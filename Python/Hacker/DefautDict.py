n,m = list(map(int,input().split()))
A = []
B = []
for i in range(n):
    A.append(input())
for i in range(m):
    B.append(input())

for i in range(len(B)):
    newItem = []
    for j in range(len(A)):
        if B[i]==A[j]:
            newItem.append(j+1)
    if len(newItem)==0:
        newItem.append(-1)
    for k in newItem:
        print(k,end=" ")    
    print()