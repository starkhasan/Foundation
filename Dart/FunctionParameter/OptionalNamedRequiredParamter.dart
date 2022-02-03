/*
 * OptionalNamedParameter
 * required tells the calling function that this parameter can not be skip in Optional Parameter
 */
void fetchData({required String name,int? age}){
  if(name != null){
    print('Name => $name');
  }
  if(age != null){
    print('Age => $age');
  }
}
void main(){
  fetchData(name: 'Ali Hasan');
}
