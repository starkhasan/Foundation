'''
def summation(arg1,*vartuple):
	print(arg1)
	add=0
	for i in vartuple:
		add=sum(i)
	print(add)
print("Enter the nnumber")
l1=[]
for i in range(0,10):
	l1.append(int(input()))
tup=tuple(l1)
summation(12,tup)
'''
print("Enter Size: ")
n=int(input())
l1=[]
print("Enter the number")
for i in range(n):
    l1.append(int(input()))
print(l1)
add=0
for i in l1:
    add=sum(i)
print(add)

