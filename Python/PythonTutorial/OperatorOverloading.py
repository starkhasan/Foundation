class Point:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def __add__(self,other):
        x = self.x+other.x
        y = self.y+other.y
        return Point(x,y)

    def __str__(self):
        return "({0},{1})".format(self.x,self.y)

p1 = Point(2,3)
p2 = Point(4,5)
p3 = p1+p2
print(p3)#or we can simply pass print(p1+p2)

"""
#In python we can also overload comparision operator
class Point:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def __lt__(self, other):
        self_mag = (self.x ** 2) + (self.y ** 2)
        other_mag = (other.x ** 2) + (other.y ** 2)
        return self_mag < other_mag

    def __str__(self):
        return "({0},{1})".format(self.x,self.y)

p1 = Point(1,1)
p2 = Point(-2,-3)
p3 = Point(1,-1)

# use less than
print(p1<p2)
print(p2<p3)
print(p1<p3)
"""


'''
Example of the Operator Overloading using StopIteration to stop the Iteration
class MyNumber:
    def __iter__(self):
        self.a = 1
        return  self
    
    def __next__(self):
        if self.a <= 20:
            x = self.a
            self.a += 1
            return x
        else:
            raise StopIteration

obj = MyNumber()
myiter = iter(obj)
for i in myiter:
    print(i)
'''
