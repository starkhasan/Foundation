
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class Demo:

    def __init__(self):
        self.head = None

    def insert(self,head,data):
        if head == None:
            head = Node(data)
        else:
            temp = head
            while temp.next!=None:
                temp = temp.next
            temp.next = Node(data)
        return head

    def print(self,head):
        temp = head
        while temp!=None:
            print(temp.data,end=" ")
            temp = temp.next

    def list_Size(self,head):
        ar_size = 0
        temp = head
        while temp!=None:
            ar_size+=1
            temp = temp.next
        return ar_size

    def reverse(self,head):
        temp = head
        current = None
        prev = None
        while temp!=None:
            current = temp.next
            temp.next = prev
            prev = temp
            temp = current
        return prev
        

obj = Demo()
list_size = int(input("Enter Size of Linked List : "))
print("Enter Element in Linked List : ")
for i in range(list_size):
    obj.head = obj.insert(obj.head,int(input()))

print("Element in Linked List : ")
obj.print(obj.head)
print("\nSize of Linked List : ")
listSize = obj.list_Size(obj.head)
print(listSize)
print("\nReverse of the Linked List : ")
obj.head = obj.reverse(obj.head)
obj.print(obj.head)