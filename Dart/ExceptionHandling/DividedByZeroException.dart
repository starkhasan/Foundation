void main(){
    var a = 10;
    try{
      var data = a ~/ 0;
    } on IntegerDivisionByZeroException{
      print('This is Interger Divided by Zero Exception ');
    } on IntegerDivisionByZeroException catch(e){
      print('This is Top Level Exception');
    } catch(e){
      print('Last One');
    }
}
