//C++ provides two dynamic allocation operators : new and delete
//these operators are used to allocate and free memory at run time in C++

/*
#include<iostream>
using namespace std;
int main(){
	int *p;
	try{
		p = new int; //allocate space for an int //p is a pointer variable that receive a pointer to memory that is large enough to hold an item of type type.
	}catch(bad_alloc xa){
		cout<<"Allocation Failure\n";
		return 1;
	}
	
	*p = 100;
	cout<<"At "<<p<<" ";
	cout<<"is the value "<<*p<<"\n";
	return 0;
}
*/

//Allocating the memory to the initilizer
#include<iostream>
using namespace std;
int main(){
	int *p;
	try{
		 p = new int(87);
	}catch(bad_alloc xa){
		cout<<"Allocation Failure\n";
		return 1;
	}
	cout<<"At "<<p<<" ";
	cout<<"is the value "<<*p<<"\n";
	return 0;
}
