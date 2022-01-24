#Function in Python

#Function Declaration for the Required Argument and Keyword Argument
def requiredArgument(a,b):
    if(a > b):
        print('A is greater than b')
    else:
        print('B is greater than A')


#Function Definition for the Default Argument
def defaultArgument(a, b = 5):
    if(a > b):
        print('A is greater than B')
    else:
        print('B is greater than A')


#Function Definition Variable Length argument
def VariableLengthArgument(a, *moreData):
    print('First Number = ',a)
    for item in moreData:
        print(item)



firstNumber = int(input('Enter First Number = '))
secondNumber = int(input('Enter Second Number = '))
#calling as Required Argument
requiredArgument(firstNumber, secondNumber)
#keyword argument
requiredArgument(b = secondNumber,a = firstNumber)
#calling default argument
defaultArgument(firstNumber)


#calling variable length argument
VariableLengthArgument(firstNumber,[1,2,3,4,5])
