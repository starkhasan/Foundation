#list comprehension
#calculate the odd and even number also their square
list=[x for x in range(0,11) if x%2==0]
print(list)
list=[x**2 for x in range(0,11) if x%2==0]
print(list)

#now for odd number
list=[x for x in range(0,11) if x%2==1]
print(list)
list=[x**2 for x in range(0,11) if x%2==1]
print(list)

string='my phone number 9760656467'
list=[x for x in string if x.isspace()]
print(list)