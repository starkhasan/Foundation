//Union is a memory location that is shared by two or more different types of variables. A Unioon provides a way of interpreting the same bit pattern in two or more different ways.
#include<iostream>
using namespace std;
union Person{
	char name[50];
	int age;
};
int main(){
	Person per,*p;
	p = &per;
	
	cout<<"Enter details of Person";
	cout<<"\nEnter Person Name = ";
	gets(p->name)
	cout<<"\nEnter Person Age = ";
	cin>>p->age;
	
	cout<<"\nDetails you entered : ";
	cout<<"\nName = ";
	puts(p->name);
	cout<<"\nAge = "<<p->age;
}

