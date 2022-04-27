a = 33
b = 100
if b > a:
    print('B is greater than A')

# Python relies on identation (whitespace at the beginning of a line) to define scope in the code.
# if statement without identation (will raise an error)


# else condition catches anything which is not caught by the preceding condition
if a > b:
    print('A is greater than B')
else:
    print('B is greater than A')


# elif keyword in python was saying, if the previous condition was not true, then try this condition
if b > a:
    print('b is greater than a')
elif a == b:
    print('a and b are equal')

# short hand if... else
# This technique is also known as Ternary Operator or Conditional Expressions
print('A') if a > b else print('B')


# pass statement
# if statement cannot be empty, but if you for some reason have an if statement with no content
# put in the pass statement to avoid getting an error

if b > a:
    pass
