
print("Author : Ali Hasan")
first_day=int(input("\nEnter First Day : "))
total_day=int(input("\nEnter Total Day (MAX 31) : "))
count=1
print("\nSUN  \tMON  \tTUE  \tWED  \tTHU  \tFRI  \tSAT")
for i in range(0,6):
    for j in range(0,7):
        if count>total_day:
            break
        if i==0:
            if j<first_day-1:
                print(" \t",end="")
            else:
                print('%2d\t'%count,end="")
                count=count+1
        if i>0:
            if j<7:
                print('%2d\t'%count,end="")
                count=count+1
            else:
                print(" ")
    print()