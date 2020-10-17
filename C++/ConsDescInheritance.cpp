/*
#include<iostream>
using namespace std;
class base{
	public:
		base(){
			cout<<"Constructor base"<<endl;
		}
		~base(){
			cout<<"Destructor base"<<endl;
		}
};
class derived:public base{
	public:
		derived(){
			cout<<"Constructor Deived"<<endl;
		}
		~derived(){
			cout<<"Destructor Derived"<<endl;
		}
};
int main(){
	derived ob;
	return 0;
}
*/


/*
//Execution order of the COnstructor and Destructor when multiple base classes (Multiple Inheritance)
#include<iostream>
using namespace std;
class base1{
	public:
		base1(){
			cout<<"Constructor base1"<<endl;
		}
		~base1(){
			cout<<"Destructor base1"<<endl;
		}
};
class base2{
	public:
		base2(){
			cout<<"Constructor base2"<<endl;
		}
		~base2(){
			cout<<"Destructor base2"<<endl;
		}
};
class derived:public base1,public base2{
	public:
		derived(){
			cout<<"Constructor derived"<<endl;
		}
		~derived(){
			cout<<"Destructor derived"<<endl;
		}
};
int main(){
	derived ob;
	return 0;
}
*/


/*
//Passing Parameter to Base-Class Constructor
#include<iostream>
using namespace std;
class base{
	protected:
		int i;
	public:
		base(int x){
			i=x;
			cout<<"Constructor base"<<endl;
		}
		~base(){
			cout<<"Destructor base"<<endl;
		}
};
class derived:public base{
	int j;
	public:
		derived(int a,int b):base(b){
			j=a;
			cout<<"Constructor derived"<<endl;
		}
		~derived(){
			cout<<"Destructor derived"<<endl;
		}
		void show();
};
void derived::show(){
	cout<<i<<" "<<j<<endl;
}
int main(){
	derived ob(1,2);
	ob.show();
	return 0;
}
*/



//parameter passing using multiple base classes
#include<iostream>
using namespace std;
class base1{
	protected:
		int i;
	public:
		base1(int x){
			i=x;
			cout<<"Constructor base1"<<endl;
		}
		~base1(){
			cout<<"Destructor base1"<<endl;
		}
};
class base2{
	protected:
		int j;
	public:
		base2(int y){
			j=y;
			cout<<"Constructor base2"<<endl;
		}
		~base2(){
			cout<<"Destructor base2"<<endl;
		}
};
class derived:public base1,public base2{
	int k;
	public:
		derived(int x,int y,int z):base1(y),base2(z){
			k=x;
			cout<<"Constructor derived"<<endl;	
		}
		~derived(){
			cout<<"Destructor derived"<<endl;
		}
		void show();
		
};
void derived::show(){
	cout<<i<<" "<<j<<" "<<k<<endl;
}
int main(){
	derived ob(1,2,3);
	ob.show();
	return 0;
}
