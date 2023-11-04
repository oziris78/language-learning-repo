
#include <stdio.h>
#include <stdlib.h>


typedef struct n{
	int x;
	struct n* next;
} Node;


int is_empty(Node* root){
	return (root->next == NULL);
}

Node* createQueue(int n){
	int i=0;
	Node* root = NULL;
	Node* temp = NULL;
	Node* p = NULL;
	
	for(i=0; i<n; i++){
		temp = (Node*) malloc(sizeof(Node));
		printf("\n%d. node icin deger giriniz: ", i+1);
		scanf("%d", &(temp->x));
		temp->next = NULL;
		if(root == NULL) {
			root = temp;
		}
		else{
			p = root;
			while(p->next != NULL){
				p = p -> next;
			}
			p -> next = temp;			
		}
	}
	
	return root;
	
}

void printQueue(Node* root){
	printf("\nQueue is: \n");
	while( root!=NULL ){
		printf("%d\n", root->x);
		root = root -> next;
	}
}

void printQueue2(Node* root){
	Node* temp;
	temp = root;
	printf("\nQueue is: \n");
	while(temp->next != NULL){
		printf("%d\n", temp->x);
		temp = temp -> next;
	}
	printf("%d\n", temp->x);
	
}

Node* getRear(Node* root){
	Node* iter;
	while(iter->next != NULL){
		iter = iter -> next; 
	}
	return iter;
}

Node* getFront(Node* root){
	Node* iter = root;
	return iter;
}


void addToRear(Node* root, int x){
	while(root->next != NULL){
		root = root -> next; 
	}
	root -> next = (Node*) malloc(sizeof(Node)); // sonraki node u olusturma
	root -> next -> x = x; // degeri ekleme
	root -> next -> next = NULL; // hata vermesin diye null yap sonrakini
}

void deleteQueue(Node* root){
	Node* temp;
	Node* pos;
	pos = root -> next;
	root->next=NULL;
	while( pos != NULL){
		temp = pos -> next;
		free(pos);
		pos = temp;
	}
	root -> x = NULL;
}

Node* deleteFromFront(Node* root){
	Node* temp;
	temp = root;
	root = root -> next;
	free(temp);
	return root;
}



int main()
{
	Node* root;
 	
 	
 	root = createQueue(3);
	printQueue(root);
	addToRear(root, 50);
	addToRear(root, 60);
	printf("------------\n");
	
	printQueue2(root);
	
	root = deleteFromFront(root);	
	
	printf("------------\n");
	
	printQueue(root);
	
	
	return 0;
}
