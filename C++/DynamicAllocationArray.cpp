#include<iostream>
using namespace std;
int main(){
	int *p;
	try{
		p = new int[10];
	}catch(bad_alloc xa){
		cout<<"Allocation Failure\n";
		return 1;
	}
	
	cout<<"Enter the Element in Array : ";
	for(int i=0;i<10;i++){
		p[i] = i;
	}
	
	
	for(int i=0;i<10;i++){
		cout<<p[i]<<" ";
	}
	
	delete []p;
	return 0;
}
