#program of swping of two number
def swap(num1,num2):
    print('Num1: ',num1,' Num2: ',num2)
    temp=0
    temp=num1
    num1=num2
    num2=temp
    print('Num1: ',num1,' Num2: ',num2)
a=int(input('Enter First Number: '))
b=int(input('Enter Second Number: '))
swap(a,b)