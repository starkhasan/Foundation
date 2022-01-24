#Membership Operator
firstList = [1,2,4,6,9]
secondList = [12,4,8,32,6]
for item in firstList:
    if(item in secondList):
        print(item,' Overlapped in secondList')
    else:
        print(item,' not present in secondList')
