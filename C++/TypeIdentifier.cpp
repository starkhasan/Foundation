#include<typeinfo>
#include<iostream>
using namespace std;
int main(){
	int number = 10;
	float f;
	char c;
	cout<<typeid(number).name();
	cout<<typeid(f).name();
}
