#include<cstring>
#include<iostream>
using namespace std;
int main(){
	char name1[50],name2[50];
	cout<<"Enter First String : ";
	gets(name1);
	cout<<"Enter Second String : ";
	gets(name2);
	
	if(strcmp(name1,name2) == 0){
		cout<<"String are Equal";
	}else{
		cout<<"String are not Equal";
	}
}
