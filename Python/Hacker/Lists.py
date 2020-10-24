file_open = open('InputDemo.txt','r',encoding='utf8')
myList = []
count = 0
file_name = file_open.readlines()
for i in file_name:
    count+=1
    element = i.strip().split(" ")
    if element[0] == "insert":
        myList.insert(int(element[1]),int(element[2]))
    elif element[0] == "print":
        print(myList)
    elif element[0] == "remove":
        myList.remove(int(element[1]))
    elif element[0] == "append":
        myList.append(int(element[1]))
    elif element[0] == "sort":
        myList.sort()
    elif element[0] == "pop":
        myList.pop()
    elif element[0] == "reverse":
        myList.reverse()