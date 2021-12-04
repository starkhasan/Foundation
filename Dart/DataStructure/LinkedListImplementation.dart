class Node {
  int? data;
  Node? next;
  Node(int data) {
    this.data = data;
    next = null;
  }
}

Node insert(Node? head, int data) {
  if (head == null)
    return Node(data);
  else {
    Node? current = head;
    while (current!.next != null) {
      current = current.next;
    }
    current.next = Node(data);
    return head;
  }
}

printLinkedList(Node? head) {
  Node? temp = head;
  while (temp != null) {
    print('${temp.data} ');
    temp = temp.next;
  }
}

main(List<String> args) {
  Node? head = null;
  List<int> nodeData = [];
  List.generate(10, (index) => nodeData.add(index + 1));
  for (var item in nodeData) {
    head = insert(head, item);
  }
  printLinkedList(head);
}
