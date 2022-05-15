# variables that are created outside of a function (as in all of the example above) are known as global variable
# global variable can be used by everyone, both inside of functions and outside


x = 'global variable'

def myFunction():
    print('I am using global variable {}'.format(x))

myFunction()



# if you create a variable with the same name inside a function this variable will be local 
# and can only be used inside the function. The global varibale with the same name will remain
# as it was, global and with the original value

y = 'global_variable'

def newFunction():
    y = 'Fantastic'
    print('Python is {}'.format(y))

newFunction()

print('Python is {}'.format(y))


# Normally when you create a variable inside a function that variable is local and can
# only be used inside that function

# to create a global variable inside a function you can use the global keyword



def myFunc():
    global z
    z = 'Local Global Variable'

myFunc()

print('I am using {}'.format(z))

# use the global keyword if you want to change a global variable inside a function

x = 'awesome'

def newFun():
    global x
    x = 'Fantastic'

newFun()

print('Python is {}'.format(x))