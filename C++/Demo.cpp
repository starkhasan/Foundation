//Program fo the swaping of two number using template
#include<iostream>
using namespace std;
template <class X> void swap(X &a,X &b){
	X temp;
	temp=a;
	a=b;
	b=temp;
}
int main(){
	int i=10,j=20;
	double x=10.2,y=23.3;
	char a='X',b='Z';
	cout<<"Original Inetger = "<<i<<" "<<j<<endl;
	cout<<"Original Double = "<<x<<" "<<y<<endl;
	cout<<"Original Character = "<<a<<" "<<b<<endl;
	swap(i,j);
	swap(x,y);
	swap(a,z);
	cout<<"Original Inetger = "<<i<<" "<<j<<endl;
	cout<<"Original Double = "<<x<<" "<<y<<endl;
	cout<<"Original Character = "<<a<<" "<<b<<endl;
	return 0;
}
