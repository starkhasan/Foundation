# Python is an object oriented programming language
# A class is like an object constructor or a blueprint for creating objects

class MyClass:
    x = 5

# we can use the class named MyClass to create objects
# create an object named p1,and print the value of x

p1 = MyClass()
print(p1.x)

# __init__()
# All classes have a function called __init__() which is always executed when the class is being initiated.
# Use the __init__() function to assign values to object properties, or other oprations that are necessary to do when the object is being created

"""class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

p1 = Person('Ali',24)
print(p1.name)
print(p1.age)"""

# __init__() function is called automatically every time the class is being used to create a new object


# class can also contain method, Methods in projects are functions that belong to the object

# An object consist of
# State : It is represented by the attributes of an object, It also reflect the properties of an object
# Behaviour : It is represented by the methods of an object, It also reflect the response of an object to
# other objects
# Identity : It gives a unique name to an object and enables one object to interact with other objects


class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def myFunction(self):
        print('Hello my name is {}'.format(self.name))

p1 = Person('Ali', 36)
p1.myFunction()

# self parameter
# The self parameter is a reference to the current instance of the class and is used to
# access variable that belongs to the class.

# it does not have to be named self you can call it whatever you like but it has to be the first
# parameter of any function in the class.



# you can modify properties on object like this
# you can delete properties on object by using the del keyword


# delete the age property from the p1 object

del p1


# class definition cannot be empty but if you for some reason have a class definition with 
# no content put in the pass statement to avoid getting an error.

class Person:
    pass


# Instance variable are for data, unique to each instance and class variable are for the attributes and methods
# shared by all instance of the class
# instance variable are variable whose value is assigned inside a constructor or methods
# class variables are variables whose value os assigned in the class

class Dog:

    # class variable
    animal = 'dog'

    # the init method or constructor
    def __init__(self,breed, color):
        #Instance variable
        self.breed = breed
        self.color = color

