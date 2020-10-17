/*
#include<cstring>
#include<iostream>
using namespace std;
void reverseName(char *name);
int main(){
	cout<<"Enter the String : "<<endl;
	char name[50];
	gets(name);
	reverseName(name);
}
void reverseName(char *name){
	cout<<"Reverse of the Name : "<<endl;
	for(int i=strlen(name)-1;i>=0;i--){
		cout<<name[i];
	}
}
*/


/*
//Converting the char array to String
#include<cstring>
#include<iostream>
void conversion(char *name);
using namespace std;
int main(){
	cout<<"Enter the Char Array : ";
	char name[50];
	gets(name);
	conversion(name);
}
void conversion(char *name){
	std::string str(name);
	cout<<"\nConverted in to String Now = "<<str;
	//Performing the substring
	cout<<"\nSub-String = "<<str.substr(4,str.length());
	//cout<<str.length();
}

*/



/*
//Example of converting a lower case name into the upper case in C++
#include<iostream>
#include<string.h>
int main(){
	char name[50];
	std::cout<<"Enter your name : ";
	gets(name);
	std::cout<<strlen(name);
	std::cout<<std::endl<<strrev(name);
	for(int i=0;i<strlen(name);i++){
		putchar(toupper(name[i]));
	}
}
*/



/*
#include<cstring>
#include<iostream>
void reverseName(char *name);
using namespace std;
int main(){
	cout<<"Enter the String : ";
	char name[50];
	gets(name);
	cout<<"Your Name = "<<name<<endl;
	for(int i=0;i<strlen(name);i++){
		cout<<name[i]<<" ";
	}
	reverseName(name);
}
void reverseName(char *name){
	cout<<"\nReverse of the Name : "<<endl;
	for(int i=strlen(name)-1;i>=0;i--){
		cout<<name[i];
	}
}
*/

/*

#include<cstring>
#include<iostream>
using namespace std;
int main(){
	cout<<"Enter the String : ";
	string str;
	getline(cin,str);
	const char *name = str.c_str();
	cout<<"This is Coverted String to Char Array = "<<name;
}
*/

/*
#include<iostream>
#include<cstring>
using namespace std;
string passStr(string str);
int main(){
	string name;
	cout<<"Enter the Stirng : ";
	getline(cin,name);
	name = passStr(name);
	cout<<name;	
}
string passStr(string str){
	cout<<str;
	return str+ "hasan";
}
*/


//Converting String to Integer
#include<iostream>
#include<cstring>
using namespace std;
int main(){
	cout<<"Enter the Integer Variable : ";
	int number = 0;
	cin>>number;
	string str_number = to_string(number);
	cout<<str_number;
	cout<<"\nLength of the Integer String = "<<str_number.length();
}
