List<int> sortListNumber(List<int> data) {
  //we will use the insertion sort algorithm for this
  var key = 0;
  for (var j = 1; j < data.length; j++) {
    key = data[j];
    var i = j - 1;
    while (i >= 0 && key < data[i]) {
      data[i + 1] = data[i];
      i -= 1;
    }
    data[i + 1] = key;
  }
  return data;
}

void main(List<String> args) {
  var listNumber = [2, 3, 4, 5, 6, 1, 8, 7, 9];
  print('Before Sorting Element');
  listNumber.forEach((element) {
    print(element);
  });
  print('After Sorting List');
  listNumber = sortListNumber(listNumber);
  listNumber.forEach((element) => print(element));
}
