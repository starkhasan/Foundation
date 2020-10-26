#Example of the variable length argument in python
def demo(*items):
    for i in items:
        print(i)

newTuple = ("Ali Hasan",22,"From Bihar","Currently Working on Android")
demo(newTuple)