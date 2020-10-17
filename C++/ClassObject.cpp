//Now we are going to talk about the the Class and object in C++

//By deafult function and data  declared within the class and private and can only be accessable only by the other member of the class.

#include<cstring>
#include<iostream>
using namespace std;
class employee{
	char name[50];
	public:
		void putname(char *n);
		void getname(char *n);
	private:
		double wages;
	public:
		void putwags(double w);
		double getwags();
};  
void employee::putname(char *n){
	strcpy(name,n);
}
void employee::putwags(double wags){
	wages = wags;
}
void employee::getname(char *n){
	strcpy(n,name);
}
double employee::getwags(){
	return wages;
}
int main(){
	employee emp;
	char name[50];
	char demo_name[50];
	cout<<"Enter the name : ";
	gets(demo_name);
	emp.putname(demo_name);
	emp.putwags(75000);
	emp.getname(name);
	cout<<"\nMy Name is = "<<name;
	cout<<"\nMy salary = "<<emp.getwags();
}
