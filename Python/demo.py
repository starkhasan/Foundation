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

#Flow Division Operator in Python




number = int(input("Enter Number\n"))
li = [] 
for i in range(2,number+1):
	li.append(i)
final_list = list(filter(lambda x: (number%x==0) , li)) 
if(len(final_list) == 1):
	print(number," is prime Number")
else:
	print(number," is not prime")


