
#include <stdio.h>
#include <stdlib.h>


typedef struct n{
	int x;
	struct n* next;
} Node;



int is_empty(Node* root){
	return (root->next == NULL);
}


int is_last(Node* pos){
	return( pos->next == NULL );
}


Node* find(int deger, Node* root) { 
	Node* pos; // konum node unu donecegimiz icin o node'u init et
	pos = root ; // bir sonraki terime git 
	while( (pos != NULL) && (pos -> x != deger) ){
		pos = pos -> next; // eger aradigimiz degilse bir sonrakine gec
	}
	return pos;
}


Node* createLinkedList(int n){
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

void printList(Node* root){
	printf("\nList is: \n");
	while( root!=NULL ){
		printf("%d\n", root->x);
		root = root -> next;
	}
}

void addToLast(Node* root, int x){

	while(root->next != NULL){
		root = root -> next; //son terime dek gitme
		// sona gidince hata vermesin diye bir sonrakine null ekleme
		if(root->next == NULL) root->next = NULL; 
	}

	root -> next = (Node*) malloc(sizeof(Node)); // sonraki node u olusturma
	root -> next -> x = x; // degeri ekleme
	root -> next -> next = NULL; // hata vermesin diye null yap sonrakini
	
}

void insert(int x, Node* root, Node* pos){ 
	Node* temp;
	temp = (Node*) malloc(sizeof(Node));
	
	if(temp != NULL){ 
	temp -> x = x;
	temp -> next = pos -> next;
	pos -> next = temp;
	}
}

Node* find_previous(int x, Node* root){ 
	Node* pos;
	pos = root;
	while( (pos->next != NULL) && (pos->next->x != x) ){ // son terim degilken ve bir sonrakisi x'e sahip degilken
		pos = pos->next; // sonraki terime gec
	} // bulunca cikar
	return pos; //cikinca bulmus olur ve onu doner
}


Node* deleteList(Node* root){
	Node* temp;
	Node* pos;
	pos = root -> next;
	root->next=NULL;
	while( pos != NULL){
		temp = pos -> next;
		free(pos);
		pos = temp;
	}
	free(root);
	Node* newNode = NULL;
	return newNode;
	
}

void deleteList2(Node* root){
	Node* temp;
	Node* pos;
	pos = root -> next;
	root->next=NULL;
	while( pos != NULL){
		temp = pos -> next;
		free(pos);
		pos = temp;
	}
	
	root = NULL;
	root -> x = NULL;
	
}

void addToLast2(Node * r, int x){
	while( r -> next != NULL){
		r =r -> next;
	}
	r -> next = (Node*) malloc(sizeof(Node));
	r -> next -> x = x;
	r -> next -> next = NULL;
}

Node* deleteElement(Node* root, int x){
	Node* temp;
	Node* iter = root;
	if( root->x == x){
		temp = root;
		root = root->next;
		free(temp);
		return root;
	}
	 
	while ( iter->next != NULL && iter -> next -> x != x){
		iter = iter->next;
	}
	if ( iter->next == NULL){
		printf( "Sayi bulunamadi!\n" );
		return root;
	}
	temp = iter -> next;
	iter -> next = iter -> next -> next; 
	free(temp);
	return root;
	}

int main()
{
	Node* root;
 	
 	
 	root = createLinkedList(3);
	printList(root);
	addToLast(root, 10);
	addToLast(root, 20);
	printf("------------\n");
	insert(999, root, find_previous(10, root));
	insert(11111, root, find(10, root));
	
	
	
	printList(root);
	
	root = deleteList(root);
	
	
	printList(root);
	
	
	
	return 0;
}
