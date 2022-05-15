# Function
# A function is a block of code which only runs when it is called
# you can pass data, known as parameter into a function
# A function can return a result


# In python a function is defined using def keyword

def myFunction():
    print('This is my simple Function')

myFunction()

# Function Argument Types

# Required Argument
# Keyword Argument
# Default Argument
# Varible length Argument => 



# Argument
# Argument are specified after the function name, inside the paranthesis 
# you can add as many argument as you want , just separate them with a comma


def myArgFunction(fname):
    print(fname+ ' Refnces')

myArgFunction('Email')
myArgFunction('Password')
myArgFunction('Name')


# Arbitrary Argument *args
# if you dont know how many arguments that will be passed into your function, add * before the parameter
# name in the function definition
# this way the function  will receive the tuple of arguments and can access  the items accordingly

def argsFunction(*args):
    print('Length of argument {}'.format(len(args)))

argsFunction('Ali','Hasan','Wali Ganj')


# Arbitrary Keyword Argument **kwargs
# If you do not know how many keyword argument that will be passed into your function , add two asterisk **
# before the parameter name in the function definition

# This way the function will receive a dictionary of argument, and can pass the item accordingly


def kargsfunction(**kid):
    print('His last name is '+kid['last_name'])

kargsfunction(first_name = 'Ali', last_name = 'Hasan')


# Default Parameter value
# The following example shows how to use a default parameter value
# If we call the function without argument it uses the default value

def defaultArgFunction(country = 'India'):
    print('I am from '+country)

defaultArgFunction()
defaultArgFunction('Australia')


# Passing a List as an argument
# you can send any data types of argument to a function (String, Number, List, Dictionary)
# and it will be treated as the same data type inside the function


def listArgFunction(listArg):
    for item in listArg:
        print(item)

fruits = ['Apple', 'Banana', 'Mango']
listArgFunction(fruits)


# Return value
# to let a function return a value use the return statement


def squareFunction(x):
    return x**2

print(squareFunction(5))


# pass statement
# function definition cannot be empty 
# but if you for some reason have a function definiton with no content 
# put in the pass statement to avoid getting an error

def myFunction():
    pass