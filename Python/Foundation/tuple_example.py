#Tuple Example
#a tuple is a sequence of immutable python object like formating number, string, literals etc
#tuple can not be change unlike lists
#tuple are defined using curve braces

tup = ('ali','hasan','wali','ganj','arrah')
print(tup)

#iterating tuple with loop
for item in tup:
    print(item)

# generally use tuple for heterogeneous datatypes and list for homogeneous datatypes
# since tuple are immutable ietrating though tuple is faster than with list, so there is slight performace boost

# print(tup+(12))
# to concatinate a single value it give an error  TyoeError: can only concatenate tuple (not "int") to tuple

print(tup+(12,))


# implementing tuple repetition
print(tup*2)

#tuple slicing
print(tup[1:4])

#tuple indexing
print(tup[2])

#Element of a tuple cannot be change once it has been assigned, but if the element is ifself a mutable datatype like list its nested items can be changed

#we cannot change the element in a tuple. That also means we cannot delete or remove items from a tuple.
# but deleting a tuple entirely is possible using the keyword del.


# count(x) => return the number of items that is equal to x
# index(x) => return index of first item that is equal to x
