
#include <stdio.h>
#include <stdlib.h>


typedef struct n{
	int x;
	struct n* next;
} Node;



int is_empty(Node* root){
	return (root->next  == NULL);
}


Node* createStack(int n){
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

void printStack(Node* root){
	printf("\nStack is: \n");
	while( root!=NULL ){
		printf("%d\n", root->x);
		root = root -> next;
	}
}

void printStack2(Node* root){
	Node* temp;
	temp = root;
	printf("\nStack is: \n");
	while(temp->next != NULL){
		printf("%d\n", temp->x);
		temp = temp -> next;
	}
	printf("%d\n", temp->x);
	
}

void push(Node* root, int x){

	while(root->next != NULL){
		root = root -> next; //son terime dek gitme
		// sona gidince hata vermesin diye bir sonrakine null ekleme
		if(root->next == NULL) root->next = NULL; 
	}

	root -> next = (Node*) malloc(sizeof(Node)); // sonraki node u olusturma
	root -> next -> x = x; // degeri ekleme
	root -> next -> next = NULL; // hata vermesin diye null yap sonrakini
	
}

int top(Node* root){
	while(root->next != NULL){
		root = root -> next; //son terime dek gitme
	}
	return root->x;
}


void push2(Node * r, int x){
	while( r -> next != NULL){
		r =r -> next;
	}
	r -> next = (Node*) malloc(sizeof(Node));
	r -> next -> x = x;
	r -> next -> next = NULL;
}

Node* pop(Node* root){
	// cok degisken olmasinin nedeni side effect ten etkilenmemek sanirim
	Node* iter;
	Node* topNode;
	Node* preTop;
	iter = root;
	// en son node u bul
	while(iter->next != NULL){
		iter = iter -> next; //son terime dek gitme
	}
	topNode = iter; // kaydet
	iter = root; // sifirlama
	
	// en sondan bir onceki node u bul
	while(iter->next->next != NULL){
		iter = iter -> next; //son terimden bir oncekine dek gitme
	}
	preTop = iter; // kaydet
	iter = root; // sifirlama
	
	free(topNode); // son terimi atma
	preTop->next = NULL; // hata vermesin diye ayarlama
	return root; // atilmis bicimde donme
	
}


int main()
{
	Node* root;
 	
 	
 	root = createStack(3);
	printStack(root);
	push(root, 10);
	push(root, 20);
	printf("------------\n");
	
	printStack2(root);
	
	printf("------------\n");
	printf("Top degeri : %d \n", top(root));
	
	printf("------------\n");
	
	pop(root);
	printStack(root);
	
	printf("Yeni top degeri : %d \n", top(root));
	
	printf("------------\n");
	
	pop(root);
	printStack(root);
	printf("------------\n");
	
	pop(root);
	printStack(root);
	printf("------------\n");
	
	pop(root);
	printStack(root);
	
	return 0;
}
