Python 3.6.4 (v3.6.4:d48eceb, Dec 19 2017, 06:54:40) [MSC v.1900 64 bit (AMD64)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> import time
>>> def countdown(n):
while n>0:
	
SyntaxError: expected an indented block
>>> import time
>>> def countdown(n):
	while n>0:
		print(n)
		time.sleep(1)
		n-=1
		if n==0:
			print("Go")

			
>>> countdown(5)
5
4
3
2
1
Go
>>> 
