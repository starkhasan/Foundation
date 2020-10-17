#include<iostream>
using namespace std;
struct Person{
	char name[50];
	int age;
};
void printDetails(Person per);
int main(){
	Person per;
	cout<<"Enter the Details of the Person : ";
	cout<<"\nName = ";
	gets(per.name);
	cout<<"Age = ";
	cin>>per.age;
	printDetails(per);
}

void printDetails(Person per){
	cout<<"Details you entered : ";
	cout<<"\nName = "<<per.name;
	cout<<"\nAge = "<<per.age;
}
