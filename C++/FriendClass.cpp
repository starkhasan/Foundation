#include<iostream>
using namespace std;
class Twovalues{
	int a,b;
	public:
		Twovalues(int i,int j){
			a=i;
			b=j;
		}
		friend class Min;
};
class Min{
	public:
		int min(Twovalues x);
};
int Min::min(Twovalues x){
	return x.a<x.b?x.a:x.b;
}
int main(){
	Twovalues two(10,12);
	Min m;
	cout<<m.min(two);
}
