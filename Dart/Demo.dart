void main() {
  var a = "[1, 2, 3]";
  var data = a.substring(1, a.length-1).split(',').map((item) => item.trim()).toList();

  for(var item in data){
    print(item);
  }
 }
