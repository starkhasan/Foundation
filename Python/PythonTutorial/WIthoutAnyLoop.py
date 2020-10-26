def printNumber(number):
    print(number,end=' ')
    if number < 100:
        printNumber(number+1)

tempNumber = int(input("Enter 1 "))
printNumber(tempNumber)