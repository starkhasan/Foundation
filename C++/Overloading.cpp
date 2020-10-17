/*
//Function Overloading 
#include<iostream>
using namespace std;
int myfunc(int i);
double myfunc(double i);
int main(){
	cout<<myfunc(10)<<" ";
	cout<<myfunc(10.5)<<" ";
}
double myfunc(double i){
	return i;	
}
myfunc(int i){
	return i;
}
*/

//Overloading Constructor
#include<iostream>
using namespace std;
class date{
	int day,month,year;
	public:
		date(char *d);
		date(int d,int m,int y);
		void showDate();
};
date::date(char *d){
	cout<<"\n"<<d;
}
date::date(int d,int m,int y){
	day = d;
	month = m;
	year = y;
}

void date::showDate(){
	cout<<day<<" "<<month<<" "<<year;
}
int main(){
	date obj(11,8,2020);
	obj.showDate();
	date obj2("11/08/2020");
}
