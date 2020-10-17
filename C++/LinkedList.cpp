#include <iostream>
using namespace std;

//Declare Node 
struct Node{
    int num;
    Node *next;
};

void display(Node *head);
Node* insertNode(Node *head,int n);
int listSize(Node *head);
Node* reverseLinkedList(Node *head);

Node* insertNode(Node *head,int n){
    Node *newNode = new Node;
    newNode->num=n;
    if(head == NULL){
    	newNode->next = head;
    	head = newNode;
	}else{
		Node *cur = head;
		while(cur->next != NULL){
			cur = cur->next;
		}
		cur->next = newNode;
		newNode->next = NULL;
	}
	
	return head;
}
Node* reverseLinkedList(Node *head){
	if(head == NULL){
		cout<<"List is empty!"<<endl;
	}else{
		Node *temp = head;
		Node *current = head;
		Node *prev = NULL;
		while(temp!=NULL){
			current = temp->next;
			temp->next = prev;
			prev = temp;
			temp = current;
		}
		
		head = prev;
		return head;
	}
}
int listSize(Node *head){
	int size = 0;
	if(head == NULL){
		size = 0;
	}else{
		Node *temp = head;
		while(temp!=NULL){
			size = size + 1;
			temp = temp->next;
		}	
	}
	return size;
}
void display(Node *head){
    if(head==NULL){
        cout<<"List is empty!"<<endl;
        return;
    }else{
		Node *temp=head;
	    while(temp!=NULL){
	        cout<<temp->num<<" ";
	        temp=temp->next;
	    }
	    cout<<endl;   
	}
}
int main(){
	Node *head = NULL;
    cout<<"Enter the Size of Linked List : ";
    int list_size;
    cin>>list_size;
    cout<<"Enter the Element in Linked List : "<<endl;
    for(int i=0;i<list_size;i++){
    	int temp;
    	cin>>temp;
    	head = insertNode(head,temp);
	}
	cout<<"\nElement of Linked List : ";
    display(head);
    cout<<"\nReverse of Linked List : ";
    head = reverseLinkedList(head);
    display(head);
    cout<<"\nLinked List Size = ";
    int linked_list_size = listSize(head);
    cout<<linked_list_size;
    return 0;
}
