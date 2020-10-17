//now we are going to the scop resolution operator
#include<iostream>
using namespace std;
class Scope{
	int number;
	public:
		void setNumber(int number);
		int getNumber();
};
void Scope::setNumber(int number){
	this->number = number;
}
int Scope::getNumber(){
	return number;
}
int main(){
	Scope scope;
	int number;
	cout<<"Enter the Number : ";
	cin>>number;
	scope.setNumber(number);
	cout<<"\nNumber = "<<scope.getNumber();
}
