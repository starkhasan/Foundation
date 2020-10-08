n=int(input("How many number do u want: "))
l=[]
print("Enter N)
for var in range(n):
	l.append(int(input()))
t=tuple(l)
def summation(*vartuple):
	sume=0
	for var in vartuple:
		sume=sum(var)
	print(sume)
summation(t)