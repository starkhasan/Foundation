#Dictonaries are used to store data values in key: value pairs
#A dictionary is a collection which is ordered, changeable and do not allow duplicates


#dictonaries is a an unorder collection of item
# to implement the collection of key value pair items


newDict = {}
print(type(newDict))

newDict = {1: 'Ali', 2: 'Hasan'}
print(newDict)

#we can get the keys using keys method
print(newDict.keys())

# we can get values using values method
print(newDict.values())

# using len function we can get the length of dictonary
print(len(newDict))

# we can also create dictonaries with mixed key
mixedDict = {'name': 'Ali Hasan', 'age': 24, 10: '2013'}
print(mixedDict)
print(mixedDict.keys())

# The value in dictionay items can be of any type
mixedDict = {
    'brand': 'Ford',
    'model': 'Mustang',
    'year': 1964
}

print(mixedDict)

# As of Python version 3.7, dictionaries are ordered. In Python 3.6 and earlier, dictionaries are unordered.
# when we say that dictionaries are ordered, it means that the items have a defined order,
# and that order will not change

# unorderd means that the items doen not have defined order, you cannot refer to an item 
# by using an index


# Dictionaries are changeable, meaning that we can change add or remove items after the dictionary has been 
# created

# Dictionaries cannot have two items with the same key



# we can access the items of a dictionary by referring to its key name, insie square brackets

print(mixedDict['year'])
# we can also use get() to access particular map item using key
print(mixedDict.get('year'))


# check if specified key present in the dictionary
if 'year' in mixedDict:
    print('Yes it is present')
else:
    print('No it is not')

# we can change the value of a specifed item by referring to its key name

mixedDict['year'] = 2018

print(mixedDict)

# update() method will update the dictionary with the items from the given argument
# if the item does not exist the item will be added
mixedDict.update({'year': 2022})

print(mixedDict)


#adding an item to the dictionary is done by using index key and assigning a value to it

mixedDict['color'] = 'Black'

print(mixedDict)



# pop() method removes the item with the specified key name

mixedDict.pop('color')

print(mixedDict)

# popitem() method removes the last inserted item 
mixedDict.popitem()


# del remove the item with the specified key name

del mixedDict['model']

# del can also delete the dictionary completely

del mixedDict


# clear method empties the dictionary

mixedDict.clear()



# copy dictionary
# you cannot copy a dictionary simple by typing dict2 = dict1, becuase dict2 will only be a reference to 
# dict1 and change made in dict1 will automatically also be made in dict2

# there are a way to make a copy
# copy() method of dictionary
# dict() method of dictionary

newMixedDict = mixedDict.copy()

temppMixedDict = dict(mixedDict)
