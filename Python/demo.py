# import math
# import numpy as np
# import matplotlib.pyplot as plt

# def estimate_coef(x, y):
# 	# number of observations/points
# 	n = np.size(x)

# 	# mean of x and y vector
# 	m_x, m_y = np.mean(x), np.mean(y)

# 	# calculating cross-deviation and deviation about x
# 	SS_xy = np.sum(y*x - m_y*m_x)
# 	SS_xx = np.sum(x*x - m_x*m_x)

# 	# calculating regression coefficients
# 	slop = SS_xy / SS_xx
# 	intercept = m_y - slop*m_x

# 	return(intercept, slop)

# def plot_regression_line(x, y, b):
# 	# plotting the actual points as scatter plot
# 	plt.scatter(x, y, color = "m",
# 			marker = "o", s = 30)

# 	# predicted response vector
# 	y_pred = b[0] + b[1]*x

# 	"""n_size=np.size(x)
# 	error=y-y_pred
# 	sqr_error=pow(error,2)
# 	rmse=math.sqrt(sum(sqr_error)/n_size)
# 	print("RMSE =",rmse)"""
# 	# plotting the regression line
# 	plt.plot(x, y_pred, color = "g")

# 	# putting labels
# 	plt.xlabel('x')
# 	plt.ylabel('y')

# 	# function to show plot
# 	plt.show()


# print("Linear Regression Model")
# dataset_size=int(input("Enter the Size of the Data Set."))
# x_model=[]
# y_model=[]
# print("Enter Data For X Model")
# for i in range(dataset_size):
#     x_model.insert(i,int(input()))

# print("Enter Data For Y Model")
# for i in range(dataset_size):
#     y_model.insert(i,int(input()))

# x = np.array(x_model)
# y = np.array(y_model)

# # estimating coefficients 
# b = estimate_coef(x, y)
# print("Estimated coefficients:\nIntercept = {} \nSlop = {}".format(b[0], b[1]))

# user_chioce=input("Do you want to Visualize the Model Graphically (Y/N)  :  ")
# if user_chioce=="y" or user_chioce=="Y" or user_chioce=="yes" or user_chioce=="Yes":
#     # plotting regression line
#     plot_regression_line(x, y, b)
# else:
#     pass

# user_check=int(input("Check For Another Number  :  "))
# print("Your Result : ",b[1]*user_check+b[0])

#OPerator in python

#String in Python concatination

'''
count = 0
file_open = open('Hasan.txt','r',encoding='utf-8')
print(file_open.seek(10))
print(file_open.read())
print(file_open.tell())
while True:
    char = file_open.read(1)
    if not char:
        break
    count = count + 1
print("Total Number of Characters = ",count)
file_open.close()
'''

'''
#Example of the Linespace

import numpy as np

new_numpy_array = np.linspace(1,5,10)
print(new_numpy_array)
'''

'''
import numpy as np
print('Generating the N Dimensional Array : ')

numpy_array = np.array([[1,2,3,4],[5,6,7,8]])
print(numpy_array)

print(numpy_array.dtype)
print(numpy_array.ndim)
print(numpy_array.shape)
print(numpy_array.size)
numpy_array.sort()
print(numpy_array)

#Generating the Zeros of the Numpy Array 

new_zeros_array = np.zeros((2,2),dtype=np.int)
print(new_zeros_array)
new_ones_array = np.ones((2,2),dtype=np.int)
print(new_ones_array)

#Reshape Operation in Numpy
print('Shape of Old Numpy Array = ',numpy_array.shape)

reshapce_numpy_array = numpy_array.reshape(4,2)

print(reshapce_numpy_array)
print('Shape of New Numpy Array = ',reshapce_numpy_array.shape)

# Flatten Operation in Numpy Array
print('\n')
print('Old Numpy Array = ',numpy_array)
flatten_numpy_array = numpy_array.flatten()
print(flatten_numpy_array)
print(flatten_numpy_array.size)
print(flatten_numpy_array[1]) #Getting Particular Item using index in flatten Array


# H Stack and V Stack in numpy Array
print('\n')
f = np.array([1,2,3,4])
g = np.array([5,6,7,8])

print(np.hstack((f,g)))
print(np.vstack((f,g)))
'''

'''
import numpy as np
new_numpy_array = np.array([[1,2,3,4],[5,6,7,8],[9,0,1,2]])
print(new_numpy_array)

print(new_numpy_array.shape)
print(new_numpy_array.size)
print(new_numpy_array.dtype)
print(new_numpy_array.ndim)

#Performing indexing and Slicing in Numpy Array
print('\nPerforming the Indexing and Slicing in  Numpy Array')
print(new_numpy_array[:])

print(new_numpy_array[1:,2:])
'''

'''
import numpy as np
a = np.arange(24)
a.ndim
b = a.reshape(2,4,3)
y = np.arange(8).reshape(4,2)
print(b)
print(y)
print(y.itemsize)
'''
'''
import numpy as np
numpyarray = np.array([[1,2,3],[4,5,6],[7,8,9]])
print(numpyarray)
print()
print(numpyarray[1:])
print()
print(numpyarray[...,1])
print()
print(numpyarray[1,...])
'''

'''
myList = [1,2,3,4,5,6,7]
myiter = iter(myList)
for i in range(len(myList)):
    print(next(myiter))

for i in range(len(myList)):
    print(myiter.__next__())
'''


'''
--------e--------
------e-d-e------
----e-d-c-d-e----
--e-d-c-b-c-d-e--
e-d-c-b-a-b-c-d-e
--e-d-c-b-c-d-e--
----e-d-c-d-e----
------e-d-e------
--------e--------
'''





