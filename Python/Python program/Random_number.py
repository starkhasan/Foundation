Python 3.6.4 (v3.6.4:d48eceb, Dec 19 2017, 06:54:40) [MSC v.1900 64 bit (AMD64)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> import random
>>> from random import randint
>>> def random_digit(n):
	start=10**(n-1)
	end=(10**n)-1
	return randint(start,end)

>>> print(random_digit(2))
51
>>> print(random_digit(8))
67839822
>>> n=random_digit(8)
>>> n
69578473
>>> n=random_digit(10)
>>> n
1404766353
>>> 
