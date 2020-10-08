"""
name=input("Enter String : ")
n=len(name)
lis=list(name)
lis1=[]

for i in range(0,n):
	lis1.append(ord(lis[i]))

new_size=len(lis1)

for i in range(1,new_size):
	if lis1[i]==32:
		continue
	key=lis1[i]
	j=i-1
	while i>=0 and lis1[j]>key:
		lis1[j+1]=lis1[j]
		j-=1
	lis1[j+1]=key

for i in range(0,new_size):
	print(lis1,end=" ")
print()

for i in range(0,new_size):
	print(chr(lis1[i]),end=" ")

"""


#implementation of dictonary
"""
d={'name':'ali hasan','age':23,'Addesss':'Noida'}
print(d)
print(d.get("name"))
"""
"""
def insertion_sort(list1):
	size=len(list1)
	key=0
	for j in range(1,size):
		key=list1[j]
		i=j-1
		while i>=0 and list1[i]>key:
			list1[i+1]=list1[i]
			i-=1
		list1[i+1]=key
	print()
	for i in range(size):
		print(list1[i],end="")

list1=[]
n=int(input("Enter size : "))
for i in range(0,n):
	list1.append(int(input()))
insertion_sort(list1)

"""
x=99
def func():
	global x
	x=88

def func1():
	global x
	x=77

func()
func1()
print(x)