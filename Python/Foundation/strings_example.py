#Strings are array of bytes representing unicode characters.
#A string is a collection of one or more characters put in a single quote, double quote or triple quote.
# in python there is no character data type,
# a character is a string of length one. It is represented by str class.

name = 'Ali hasan'
print(name)

#string concatination 
name = name + ' From Wali Ganj, Arrah Bihar'
print(name)

#String repetition
print(name*2)

#string slicing
print(name[1:4])

#string indexing
print(name[4])

#string reverse
print(name[::-1])


#string methods
#find() which is used to find the substring in the string
#replace() which is used to replace a string with other string
#count() which is used to count the number of times a substring present in the string
#upper() to make the string in upper case
#and many more function 