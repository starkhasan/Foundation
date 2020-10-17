//Example of the Default-to-Int Function
#include<iostream>
using namespace std;
int sum(int,int);
int main(){
	cout<<"Enter two Number : ";
	int a,b;
	cin>>a>>b;
	int z = sum(a,b);
	cout<<"\nSummation = "<<z;
}
sum(int a,int b){
	return a+b;
}
