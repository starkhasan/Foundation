class Node {
  int? data;
  Node? next = null;
  Node(int data){
    this.data = data;
    next = null;
  }
}

class LinkedList {


  Node insertNode(Node? head, int data){
    if(head == null){
      return Node(data);
    } else {
      var current = head;
      while(current.next != null) {
        current = current.next!;
      }
      current.next = Node(data);
      return head;
    }
  }

  void printLinkedList(Node? node){
    Node? temp = node;
    while(temp != null){
      print(temp.data);
      temp = temp.next;
    }
  }
}

void main(){
  var obj = LinkedList();
  Node? head = null;
  var input = [1,2,3,4,5,6,7];
  for(var item in input){
    head = obj.insertNode(head, item);
  }

  obj.printLinkedList(head);
}