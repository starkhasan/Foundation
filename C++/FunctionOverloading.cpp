#include<iostream>
using namespace std;
int myfunc(int i);
double myfunc(double i);
int main(){
	cout<<myfunc(10)<<" ";
	cout<<myfunc(10.5)<<" ";
}
double myfunc(double i){
	return i;	
}
myfunc(int i){
	return i;
}
