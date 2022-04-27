#mutable data
templist = ['Ali','Hasan', 23, 'Wali Ganj', 'Arrah', 'Bhojpur']
print(templist) 

#iterate list item using for loop
for item in templist:
    print(item)

# we can get the address of an object using id function id(DATA_TYPE)
print(id(templist))

#append takes only one parameter and add that element at the end of list
templist.append('Bihar')
templist.append('802301')
templist.append('India')

print(id(templist))

#different operation we can perform on list
#concatination
#repetition
#slicing
#indexing

templist += ['Anand', 'Engineeing', 'Collage']  #concatination
print(templist)

print(templist*2)   #repetition

print(templist[2:5]) #slicing

print(templist[4])  #indexing

templist.remove('Arrah')  #remove method remove a single item from the list and does not return any value

templist.reverse()  #reverse method reverse the list and does not return any value
print(templist)

newlist = [1,3,5,6,7,2,0]
newlist.sort()  #sort function sort the list but does not return any value
print(newlist)



