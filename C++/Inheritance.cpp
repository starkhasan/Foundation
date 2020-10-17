/*
//Demo of the Inheritance in C++
#include<iostream>
using namespace std;
class base{
	int i,j;
	public:
		void set(int a,int b);
		void show();
};
class derived:public base{
	int k;
	public:
		derived(int x){
			k=x;
		}
		void showk();
};
void base::set(int a,int b){
	i=a;
	j=b;
}
void base::show(){
	cout<<i<<" "<<j<<endl;
}
void derived::showk(){
	cout<<k<<endl;
}
int main(){
	derived obj(3);
	obj.set(1,2);//access member of base
	obj.show();//access member of base
	obj.showk();//access member of derived class
	return 0;
}
*/


/*
#include<iostream>
using namespace std;
class base{
	int i,j;
	public:
		void set(int a,int b);
		void show();
};
class derived : private base{
	int k;
	public:
		derived(int x){
			k=x;
		}
		void showk();
		
};
void base::set(int a,int b){
	i=a;
	j=b;
} 
void base::show(){
	cout<<i<<" "<<j<<endl;
}
void derived::showk(){
	cout<<k<<" ";
}
int main(){
	derived ob(3);
	ob.set(1,2); //error, can't access set() because they become private on inheriting using private access
	ob.show();//error, can't access show() because they are become private on inheriting using private access
	ob.showk();
	return 0;
}
*/

/*
#include<iostream>
using namespace std;
class base{
	protected:
		int i,j;
	public:
		void set(int a,int b);
		void show();
};
class derived:public base{
	int k;
	public:
		void setk();
		void showk();
};
void base::set(int a,int b){
	i=a;
	j=b;
}
void base::show(){
	cout<<i<<" "<<j;
}
void derived::setk(){
	k = i*j;
}
void derived::showk(){
	cout<<k<<endl;
}
int main(){
	derived ob;
	ob.set(1,3);
	ob.show();
	ob.setk();
	ob.showk();
	return 0;
}
*/






