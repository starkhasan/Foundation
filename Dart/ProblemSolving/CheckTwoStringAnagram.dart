main(){
  var firstString = "Ali";
  var secondString = "hia";

  //Check it two string are anagram to each other

  firstString = firstString.toLowerCase();
  secondString = secondString.toLowerCase();

  var a = firstString.split('');
  var b = secondString.split('');

  //performing string sorting
  a.sort();
  b.sort();
  
  if(a.length != b.length){
    print('Both string are not anagram');
  }else{
    var value = b.every((item) => a.contains(item));
    if(value){
      print('Both Strings Anagram');
    }else{
      print('Both Strings are not Anagram');
    }
  }

}
