#set are used to store multiple item in a single variable
# a set is a collection which is unordered, unchangeable and unindexed.
# set items are unchangeable but you can remove items and add new items


mySet = {'Apple', 'Banana', 'Grapes', 'Leamon', 'Orange'}

print(type(mySet))
print(mySet)

# undered means that the items in a set do not have a defined order


# we cannot access items in a set by referring to an index or a key
# but we can loop through the set items using a for loop or ask if a specified value is present in a set by using the in keyword

for item in mySet:
    print(item)


# once a set is created, you cannot change its items but you can add new items
# using add() method

mySet.add('Watermelon')
print(mySet)


# to add item from another set into current set use the update() method
thisset = {"apple", "banana", "cherry"}
tropical = {"pineapple", "mango", "papaya"}

thisset.update(tropical)

print(thisset)


# the object in the update() method does not have to be set it can be any iterable object (tuple, lists, dictionaries etc)



# remove an item a set, use the remove() or the discard() method

thisset.remove('apple')
print(thisset)


# it the item to remove does not exist, remove() will raise an error

# if the item to remove does not exist discard will not raise an error


# clear() method empties the set

# del keyword will delete the set completely
