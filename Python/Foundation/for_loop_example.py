# for loop is used for iterating over the sequence 
# (that is either a list, a tuple, a dictionary, a set, or a string)

# iterating on string
newStr = 'Ali Hasan'
for item in newStr:
    print(item)

# break 
# we can stop the loop before it has looped through all the items
fruits = ['Apple', 'Banana', 'Cherry']
for item in fruits:
    print(item)
    if item == 'Banana':
        break


# continue
# we can stop the current iteration of the loop and continue with the next

for item in fruits:
    if item == 'Banana':
        continue
    print(item)


# range() function
# to iterate through a set of code a specified number of times, we can use the range() function
# range function returns a sequence of number  starting from 0 by default and increment by 1 (by default), and end at specified number

for x in range(6):
    print(x)

# range() function however it is possible to specify the starting value by adding a parameter range(2,5)
# which means  values from 2 to 6 (but not including 6)

for item in range(2, 6):
    print(item)

# range() function by default to increment the sequence by 1, however it is possible to specify the increment
# value by adding a third parameter range(2, 30, 3)
for item in range(2, 30, 3):
    print(item) 

# else in for loop
# else keyword in for loop specify a block of code to be executed when the loop if finished
for item in range(4):
    print(item)
else:
    print('Finally Finihsed!!')

# else block will not be executed if the loop is stopped by a break statement



# Nested Loop is a loop inside a loop
# the inner loop will be executed one time for each iteration of the outer loop


# pass statement
# for loop cannot be empty, but if you for some reason have a for loop with no content put in the pass statement
# to avoid getting an error

for x in range(10):
    pass