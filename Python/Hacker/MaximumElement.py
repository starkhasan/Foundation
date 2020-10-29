newList = [0]
for i in range(int(input())):
    number = list(map(int,input().split()))
    if len(number)>1:
        newList.append(max(number[1],newList[-1]))
    else:
        if number[0] == 2 and len(newList)>0:
            newList.pop()
        elif number[0] == 3:
            print(newList[-1])