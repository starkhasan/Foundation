class Node {
  Node? left;
  Node? right;
  int? data;
  Node(int data) {
    this.data = data;
    left = right = null;
  }
}

Node insert(Node? root, int data) {
  if (root == null)
    return Node(data);
  else {
    if (data < root.data!) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }
}

printInorder(Node? root) {
  if (root != null) {
    printInorder(root.left);
    print('${root.data} ');
    printInorder(root.right);
  }
}

printPreorder(Node? root) {
  if (root != null) {
    print('${root.data} ');
    printPreorder(root.left);
    printPreorder(root.right);
  }
}

main(List<String> args) {
  Node? root = null;
  var listNode = [5, 8, 3, 4, 2, 10, 6];
  for (var item in listNode) {
    root = insert(root, item);
  }
  print('\nInorder Traversal of the BinarySearch Tree : ');
  printInorder(root);
  print('\nPreorder Traversal of the BinaySearch Tree : ');
  printPreorder(root);
}
