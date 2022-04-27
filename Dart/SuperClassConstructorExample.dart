class Student{

  /// No Argument Constructor / Default Constructor
  // Student(){
  //   print('calling no argument constructor');
  // }

  /// Parametrized Constructor
  Student({required String branch}){
    print('Parametrized Parent Constructor $branch');
  }

}
class ComputerScience extends Student {

  ComputerScience({String? year,required String branch}) : super(branch: branch){
    print('Parametrized Child Constructor $year');
  }


}

void main(){
  var obj = ComputerScience(year: 'First',branch: 'Computer Science');
}
