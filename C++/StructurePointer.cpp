#include<iostream>
using namespace std;
struct Person{
	char name[50];
	int age;
};
int main(){
	Person person,*p;
	p = &person;
	cout<<"Enter the Person Name : ";
	gets(p->name);
	cout<<"Enter the Person Age : ";
	cin>>p->age;
	
	
	cout<<"\nDetails you entered";
	cout<<"\nName = "<<p->name<<"\nAge = "<<p->age;
}
