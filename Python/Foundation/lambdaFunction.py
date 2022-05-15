#Anonymous function also known as Lambda Function
# These function are called anonymous becuase they are not declared in the standard manner by using the def keyword,
# you can use the lambda keyword to create small anonymous function

#lambda forms can take any number of arguments but returns just one value in the form of an expression.
#They canno contain compound or multiple expressions


number = lambda num1,num2: num1+num2
print(number(1,2))