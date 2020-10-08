string='alihasan'
print(string)
print(string.count('a',0,7))
print(string.replace('ali','ai'))
print(string.replace('alihasan','alas'))
print(string.find('hasan'))
print(string.split(','))
print(max(string))
print(string.upper())
string1='ALIHASAN'
print(string1.lower())

"""
#tuple
tup=('a','x','e')
print(tup
+('b','e'))#tuple concatenation
print(tup*2)#tuple repetition
print(tup)
print(tup[1])#tuple indexing

"""
"""
#List
list=['alihasna',2.5,5,'sahid']
print(list+['ali','hasan'])
print(list*2)
list.append('ali')
print(list)
print(list+['sahid'])
list.extend(['data','undo'])
print(list)
list.insert(2,'papu')
print(list)
list.pop()
print(list)
"""

#flow control
'''
#if...elif...else statement
mark=70
if(mark>80):
    print("Grade A")
elif(mark>60) and (mark<=80):
    print("Grade B")
elif(mark>40) and (mark<=60):
    print("Grade C")
else:
     print("Grade D")
'''
'''
#taking input from user
#using of while loop
num=int(input("Enter the value of n="))#it is used to take the input form user
if(num<=0):
    print("Enter the valid number")
else:
    sum=0
    while(num>0):
        sum+=num
        num-=1
print(sum)

'''

#for statement
'''
number=[1,2,3,4,5]
sum=0
for var in number:
    sum+=var

print(sum)
'''

#pattern printing
#1
'''
n=int(input("Enter the size of the pattern"))
for i in range(0,n):
    for j in range(0,n):
        if j<=i :
            print("*",end=" ")
        else:
            print(end=" ")
    print()
'''
'''
#2
n=int(input("Size of Pattern = "))
for i in range(0,n):
    for j in range(0,n):
        if j<n+1-i :
            print("*",end=" ")
        else:
            print(end=" ")
    print()
'''
'''
#3
#using continue statement
for x in range(20):
    if(x%2)==0:
        continue
    print(x)
'''
#FUNCTION IN PYTHON
'''
def add(a,b):
    sum=a+b
    return sum
num1=int(input("Enter First number"))
num2=int(input("Enter the second number"))
print(add(num1,num2))
'''
def fibo(n):
    a=0
    b=1
    for x in range(n):
        a=b
        b=a+b
        print(a,'\n')
    return b
num=int(input("Enter the value of n :"))
print(fibo(num))
'''
'''
class Student:
    pass
Std_1=Student()
Std_2=Student()
Std_1.first='ali'
Std_1.last='hasan'
Std_1.email='alihasan226@gmail.com'
Std_1.marks=75
print(Std_1.email)
'''











