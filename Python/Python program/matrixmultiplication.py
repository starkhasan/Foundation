"""
Python 3.6.4 (v3.6.4:d48eceb, Dec 19 2017, 06:54:40) [MSC v.1900 64 bit (AMD64)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> #take two matrices X and Y and a result matrices
>>> X=[[1,2,3],
       [4,5,6],
       [7,8,9]]
>>> Y=[[10,11,12],
       [13,14,15],
       [16,17,18]]
>>> result=[[0,0,0],
	    [0,0,0],
	    [0,0,0]]
>>> for i in range(len(X)):
	for j in rannge(len(X[0])):
		result[i][j]=X[i][j]+Y[i][j]

		
Traceback (most recent call last):
  File "<pyshell#14>", line 2, in <module>
    for j in rannge(len(X[0])):
NameError: name 'rannge' is not defined
>>> for i in range(len(X)):
	for j in range(len(X[0])):
		result[i][j]=X[i][j]+Y[i][j]

		
>>> for r in result:
	print(r)

	
[11, 13, 15]
[17, 19, 21]
[23, 25, 27]
>>> 
"""
N=[[1,2,3],
       [4,5,6],
       [7,8,9]]
		      
M=[[0,1,2],
       [3,4,5],
       [6,7,8]]
		      
o=[[0,0,0],
       [0,0,0],
       [0,0,0]]
	   
for i in range(0,3):
	for j in range(0,3):
		o[i][j]=0
		for k in range(0,3):
			o[i][j]=o[i][j]+(N[i][k]*M[k][j])	      
for r in o:
	print(r)

"""		      
[24, 30, 36]
[51, 66, 81]
[78, 102, 126]
"""

















