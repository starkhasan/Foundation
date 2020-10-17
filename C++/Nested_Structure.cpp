#include<iostream>
struct Address{
	int house_number;
	char stree_name[50];
	int zip_code;
	char state[50];
	char country[50];
};
struct Person{
	char name[50];
	int age;
	long int salary;
	struct Address address;
};
int main(){
	Person person;
	std::cout<<"Enter the personal Details of the user : \n";
	std::cout<<"Name = ";
	gets(person.name);
	std::cout<<"\nAge = ";
	std::cin>>person.age;
	std::cout<<"\nSalary = ";
	std::cin>>person.salary;
	std::cout<<"\nHouse Number : ";
	std::cin>>person.address.house_number;
	std::cout<<"\nStreet Name = ";
	std::cin.sync();
	gets(person.address.stree_name);
	std::cout<<"\nZip Code = ";
	std::cin>>person.address.zip_code;
	std::cin.sync();
	std::cout<<"\nState = ";
	gets(person.address.state);
	std::cout<<"\nCountry = ";
	gets(person.address.country);
	
	std::cout<<"\nDetails you entered : ";
	std::cout<<"\n"<<person.name;
	std::cout<<"\n"<<person.age;
	std::cout<<"\n"<<person.salary;
	std::cout<<"\n"<<person.address.house_number;
	std::cout<<"\n"<<person.address.stree_name;
	std::cout<<"\n"<<person.address.zip_code;
	std::cout<<"\n"<<person.address.state;
	std::cout<<"\n"<<person.address.country;
}
