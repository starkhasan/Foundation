#include<iostream>
#include<stdio.h>
struct Biodata{
	char name[50];
	char gender;
	int age;
	char address[100];
	long int phone_number;
};
int main(){
	std::cout<<"Please fill your personal details\n";
	Biodata b_data;
	std::cout<<"Please enter your name\n";
	gets(b_data.name);
	std::cout<<"Please provide the gender you are\n";
	b_data.gender = getchar();
	std::cout<<"Please provide the age\n";
	std::cin>>b_data.age;
	std::cin.sync();
	std::cout<<"Please provide the address\n";
	gets(b_data.address);
	std::cout<<"Please provide your phone number\n";
	std::cin>>b_data.phone_number;
	
	
	std::cout<<"\nDetails of the Student are as follow :-";
	std::cout<<b_data.name<<" "<<b_data.age<<" "<<b_data.gender<<" "<<b_data.address<<" "<<b_data.phone_number;
	
}
