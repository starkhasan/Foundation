/*
Unsized Array
If in an array initialization statement the size of the array is not specified the C/C++ compiler automatically creates an array big enough to hold all the initializers present. this is called unsized array.
*/
#include<iostream>
#include<string.h>
int main(){
	char str[11] = "i like c++";
	std::cout<<str;
	std::cout<<"\n"<<strlen(str);
}
