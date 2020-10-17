/*
#include<cstring>
#include<iostream>
using namespace std;
class Balance{
	double cur_bal;
	char name[50];
	public:
		void set_bal(double n,char *s);
		void get_bal(double &n,char *s);
};
void Balance::set_bal(double n,char *s){
	cur_bal = n;
	strcpy(name,s);
}
void Balance::get_bal(double &n,char *s){
	n = cur_bal;
	strcpy(s,name);
}
int main(){
	Balance *bal;
	char name[40];
	double balance;
	try{
		bal = new Balance();
	}
	catch(bad_alloc xa){
		cout<<"Allocation Failure\n";
		return 1;
	}
	
	cout<<"Enter your Name : ";
	gets(name);
	bal->set_bal(12387.45,name);
	bal->get_bal(balance,name);
	cout<<name<<" 's balance is "<<balance;
	delete bal;
	return 0;
}
*/


//Allocating object may have constructor and destructor also.
#include<cstring>
#include<iostream>
using namespace std;
class Balance{
	double cur_bal;
	char name[50];
	public:
		Balance(double n,char *s){
			cur_bal = n;
			strcpy(name,s);
		}
		~Balance(){
			cout<<"Destructing = ";
			cout<<name<<endl;
		}
		
		void get_bal(double &n,char *s);
};
void Balance::get_bal(double &n,char *s){
	n = cur_bal;
	strcpy(s,name);
}
int main(){
	Balance *balance;
	char name[50];
	double new_bal;
	cout<<"Enter your Name = ";
	gets(name);
	try{
		balance = new Balance(12387.87,name);
	}catch(bad_alloc xa){
		cout<<"Allocation Failure\n";
		return 1;
	}
	
	balance->get_bal(new_bal,name);
	cout<<name<<" 's balance is : "<<new_bal;
	cout<<"\n";
	delete balance;
	return 0;
}
