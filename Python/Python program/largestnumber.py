a=int(input('Enter A: '))
b=int(input('Enter B: '))
c=int(input('Enter C: '))
d=int(input('Enter D: '))
e=int(input('Enter E: '))
if (a>b)and(a>c)and(a>d)and(a>e):
    print('LARGEST NUMBER: A')
elif (b>c)and(b>d)and(b>e):
    print('LARGEST NUMBER: B')
elif (c>d)and(c>e):
    print('LARGEST NUMBER: C')
elif (d>e):
    print('LARGEST NUMBER: D')
else:
    print('LARGEST NUMBER: E')
            