#program for priting pyramid
#pattern operation
import time
n=int(input("Enter The Size: "))
for i in range(n):
    for j in range(n):
        if (i<(n+1)/2):
            if (j>=i  and j<n-i):
                print("-",end=" ")
                time.sleep(1/100)
                
            else:
                print("|",end=" ")
                time.sleep(1/100)
        else:
            if (j>=(n-1-i) and j<=i):
                print("-",end=" ")
                time.sleep(1/100)
            else:
                print("|",end=" ")
                time.sleep(1/100)
    print()