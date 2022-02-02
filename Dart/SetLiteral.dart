void main(){
  /*
   * Creating a Set using SetLiteral  {'Ali','Hasan','Wali'}
   *
   * if we creating a Set using SetLiteral then it will behave as the HashMap {}
   * So to create the Empty Set using explicit declaration of Set<>()
   *
   */
  var setLieral = {'Ali','Hasan','Wali','Arrah','Ali'};
  print('Type of the Set => ${setLieral.runtimeType}');
  setLieral.forEach((item) => print(item));
}
