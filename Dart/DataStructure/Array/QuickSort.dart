import '../../ProblemSolving/QuickSort.dart';

void quickSort(List<int> array, int p, int r){
  if(p <= r){
    int q = partition(array, p, r);
    quickSort(array, p, q - 1);
    quickSort(array, q + 1, r);
  }
}

void main() {
  var array = <int>[4,5,3,6,1,8,9,2];
  print("Before Sorting => $array");
  quickSort(array, 0, array.length - 1);
  print("After Sorting => $array");
}