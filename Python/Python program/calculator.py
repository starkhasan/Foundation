restart='Y'
n=1
while n>0:
    a=int(input('First Number: '))
    b=int(input('Second Number: '))
    print("\n1.Addition")
    print('2.Subtraction')
    print('3.Multiplication')
    print('4.Division')
    option=int(input('\nEnter optin: '))
    if option==1:
        print('Sum = ',a+b)
        restart=input('Want to Continue: ')
        if restart == 'N':
            print('Thank you')
            break
    elif  option==2:
        print('Subtraction = ',a-b)
        restart=input('Want to Continue: ')
        if restart == 'N':
            print('Thank U: ')
            break
    elif option==3:
        print('Multiplication = ',a*b)
        restart=input('Want to continue: ')
        if restart == 'N':
            print('Thank U: ')
            break
    elif option==4:
        print('Division = ',a/b)
        restart=input('Want to Continue: ')
        if restart == 'N':
            print('Thank u: ')
            break
    else:
        print('Invalid Input: ')
        break