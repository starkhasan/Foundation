//Constructor with one parameter
#include<iostream>
using namespace std;
class myclass{
	int a;
	public:
		myclass(int i){
			a=i;
		}
		void show();
};
void myclass::show(){
	cout<<a;
}
int main(){
	myclass obj = 99;
	obj.show();
}
