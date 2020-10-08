'''
n=int(input("Enter the number: "))
if(n>10):
    print("Number is Greater than 10")
elif(n<10):
    print("Number is Smaller than 10")
elif(n==10):
    print("Same number")
else:
    print("Invalid Number")
'''
'''
sum=0
for i in range(0,11):
    sum+=i
print(sum)
'''
'''
n=int(input('Enter the number'))
for i in range(1,11):
    print(n,' x ',i,' = ',n*i)
'''
'''
n=int(input("Enter size"))
for i in range(0,5):
    for j in range(0,5):
        if(j<=n):
            print("*",end=" ")
        else:
            print(" ")
    print()
'''
'''
for i in range(0,5):
    for j in range(0,5):
        if j==3:
            print("Element Found; ")
            pass
        print(j)
    print(i)
'''
'''
a=int(input('First Number: '))
b=int(input('Second Number: '))
restart=('Y')
n=1
while n>0:
    print("1.Addition")
    print('2.Subtraction')
    print('3.Multiplication')
    print('4.Division')
    option=int(input('Enter optin: '))
    if option==1:
        print('Sum = ',a+b)
        restart=input('Want to Continue: ')
        if restart in ('N'):
            print('Thank U: ')
            break
    elif  option==2:
        print('Subtraction = ',a-b)
        restart=input('Want to Continue: ')
        if restart in ('N'):
            print('Thank U: ')
            break
    elif option==3:
        print('Multiplication = ',a*b)
        restart=input('Want to continue: ')
        if restart in ('N'):
            print('Thank U: ')
            break
    elif option==4:
        print('Division = ',a/b)
        restart=input('Want to Continue: ')
        if restart in ('N'):
            print('Thank U: ')
            break
    else:
        n=0
        print('Thank U: ')
        break
'''
'''
condition=True
if(condition==True):
    print('ok')
'''
"""
s='alihasan'
print(s[:])
print(s[0:len(s)-1:2])
print(s[0:len(s)-1:1])
print(s[0:len(s)-1:3])
print(s[0::3])
print(s[::3])
print(s[::-1])
print(s[::-3])
print(s[::])

"""


def smart_multiplication(func):
    def inner(N, M):
        col_N = len(N[0])
        row_M = len(M)
        print(col_N, ' ', row_M)
        if col_N != row_M:
            print("can't multiply")
            return
        return (N, M)

    return inner

@smart_multiplication
def multiplication(N, M):
    for i in range(0, 3):
        for j in range(0, 4):
            o[i][j] = 0
            for k in range(0, 2):
                o[i][j] = o[i][j] + (N[i][k] * M[k][j])
    for r in o:
        return r


N = [[1, 3], [2, 4], [2, 5]]

M = [[1, 3, 2, 2], [2, 4, 5, 1]]

o = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]

multiplication(N, M)







