#include<iostream>
using namespace std;
class c1{
	int i;
	public:
		c1(int j){
			i=j;
		}
		int get_i(){
			return i;
		}
};
int main(){
	c1 obj(88),*p;
	p = &obj;
	cout<<p->get_i();
}
