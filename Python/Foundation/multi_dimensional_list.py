#we can implement multiple dimentional list or array using nested list

newlist = [[1,2,3],[4,5,6],[7,8,9]]

#itering through the each index list
for item in newlist:
    print(item)

#return the sum of each individual list
for item in newlist:
    print(sum(item))

#return the sum of entire 2d list

tempSum = 0
for item in newlist:
    tempSum+=sum(item)
print('Total sum of 2D list = {}'.format(tempSum))