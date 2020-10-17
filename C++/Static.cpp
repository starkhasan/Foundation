/*
#include<iostream>
using namespace std;
class Shared{
	static int a;
	int b;
	public:
		void setData(int i,int j);
		void show();
};
int Shared::a;
void Shared::setData(int i,int j){
	a=i;
	b=j;
}
void Shared::show(){
	cout<<"This is static a : "<<a;
	cout<<"\nThis is non-static b : "<<b;
	cout<<endl;
}
int main(){
	Shared obj1,obj2;
	
	obj1.setData(1,1);
	obj1.show();
	
	obj2.setData(2,2);
	obj2.show();
	
}
*/
//a static member varible exists before any object of its class is created.

#include<iostream>
using namespace std;
class Shared{
	public:
		static int a;
};
int Shared::a;
int main(){
	Shared::a = 99;
	cout<<"This is initial value of a : "<<Shared::a;
	Shared obj;
	cout<<"\nThis is : "<<obj.a;
}
