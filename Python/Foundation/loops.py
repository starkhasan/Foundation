#Loops for, while
a = 5
for i in range(a):
    print('Ali Hasan')

#performing loops on sequence

#Simple String
yourName = 'Ali Hasan'
for item in yourName:
    print(item)

#Simple list
simpleList = [1,2,3,4,5,6,7,8,9,10]
for item in simpleList:
    print(item)


#Star Pattern
for i in range(a+1):
    for j in range(a+1):
        if(i<j):
            print('*',end='')
        else:
            print(end='')
    print()


#while loop example
i = 0;
while i < a:
    print(i)
    i+=1
