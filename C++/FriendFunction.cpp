//Is is possible to access the private member of class using nonmember function using friend function
#include<iostream>
using namespace std;
class myclass{
	int a,b;
	public:
		friend int sum(myclass x);
		void setData(int i,int j);
};
void myclass::setData(int i,int j){
	a=i;
	b=j;
}
int sum(myclass x){
	return x.a+x.b;
}
int main(){
	myclass object;
	object.setData(12,12);
	cout<<sum(object);
}
